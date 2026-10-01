package vn.edu.huy.dao.impl;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import vn.edu.huy.dao.*;
import vn.edu.huy.model.*;
import vn.edu.huy.util.*;

public class OrderDaoImpl_24162049 implements OrderDao_24162049 {
 public long create(String username,String recipientName,String phone,String address,String note,Collection<CartItem_24162049> items){
  try(Connection c=ConnectionUtil_24162049.getConnection()){
   c.setAutoCommit(false);
   try{
    long orderId;
    String insertOrder="INSERT INTO Orders(Username,RecipientName,Phone,Address,Note,PaymentMethod,Status,TotalAmount) VALUES(?,?,?,?,?,'COD','NEW',0)";
    try(PreparedStatement p=c.prepareStatement(insertOrder,Statement.RETURN_GENERATED_KEYS)){
     p.setString(1,username);p.setString(2,recipientName);p.setString(3,phone);p.setString(4,address);p.setString(5,note.isBlank()?null:note);p.executeUpdate();
     try(ResultSet keys=p.getGeneratedKeys()){if(!keys.next())throw new SQLException("Không tạo được mã đơn hàng.");orderId=keys.getLong(1);}
    }
    BigDecimal total=BigDecimal.ZERO;
    boolean h2=c.getMetaData().getDatabaseProductName().toLowerCase(Locale.ROOT).contains("h2");
    String productSql=h2?"SELECT Title,Poster,Price,Stock,Active FROM Videos WHERE VideoId=? FOR UPDATE":"SELECT Title,Poster,Price,Stock,Active FROM Videos WITH (UPDLOCK,ROWLOCK) WHERE VideoId=?";
    for(CartItem_24162049 cartItem:items){
     String title,poster;BigDecimal price;int stock;boolean active;
     try(PreparedStatement p=c.prepareStatement(productSql)){p.setString(1,cartItem.getProduct().getVideoId());try(ResultSet r=p.executeQuery()){
      if(!r.next())throw new IllegalArgumentException("Sản phẩm không còn tồn tại.");title=r.getString("Title");poster=r.getString("Poster");price=r.getBigDecimal("Price");stock=r.getInt("Stock");active=r.getBoolean("Active");
     }}
     int quantity=cartItem.getQuantity();
     if(!active||stock<quantity)throw new IllegalArgumentException("Sản phẩm “"+title+"” chỉ còn "+Math.max(stock,0)+" sản phẩm.");
     try(PreparedStatement p=c.prepareStatement("UPDATE Videos SET Stock=Stock-? WHERE VideoId=? AND Stock>=?")){p.setInt(1,quantity);p.setString(2,cartItem.getProduct().getVideoId());p.setInt(3,quantity);if(p.executeUpdate()!=1)throw new IllegalArgumentException("Tồn kho vừa thay đổi, vui lòng kiểm tra lại giỏ hàng.");}
     try(PreparedStatement p=c.prepareStatement("INSERT INTO OrderItems(OrderId,VideoId,Title,Poster,UnitPrice,Quantity) VALUES(?,?,?,?,?,?)")){p.setLong(1,orderId);p.setString(2,cartItem.getProduct().getVideoId());p.setString(3,title);p.setString(4,poster);p.setBigDecimal(5,price);p.setInt(6,quantity);p.executeUpdate();}
     total=total.add(price.multiply(BigDecimal.valueOf(quantity)));
    }
    try(PreparedStatement p=c.prepareStatement("UPDATE Orders SET TotalAmount=? WHERE OrderId=?")){p.setBigDecimal(1,total);p.setLong(2,orderId);p.executeUpdate();}
    c.commit();return orderId;
   }catch(SQLException|RuntimeException e){c.rollback();throw e;}
  }catch(SQLException e){throw new DataAccessException_24162049(e);}
 }
 public List<Order_24162049> list(String username,String status){
  String sql="SELECT * FROM Orders WHERE Username=? AND (?='' OR Status=?) ORDER BY CreatedAt DESC,OrderId DESC";
  try(Connection c=ConnectionUtil_24162049.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,username);p.setString(2,status);p.setString(3,status);try(ResultSet r=p.executeQuery()){List<Order_24162049> list=new ArrayList<>();while(r.next())list.add(mapOrder(r));return list;}}catch(SQLException e){throw new DataAccessException_24162049(e);}
 }
 public Order_24162049 find(String username,long orderId){
  try(Connection c=ConnectionUtil_24162049.getConnection()){
   Order_24162049 order;
   try(PreparedStatement p=c.prepareStatement("SELECT * FROM Orders WHERE OrderId=? AND Username=?")){p.setLong(1,orderId);p.setString(2,username);try(ResultSet r=p.executeQuery()){order=r.next()?mapOrder(r):null;}}
   if(order==null)return null;
   try(PreparedStatement p=c.prepareStatement("SELECT * FROM OrderItems WHERE OrderId=? ORDER BY OrderItemId")){p.setLong(1,orderId);try(ResultSet r=p.executeQuery()){while(r.next()){OrderItem_24162049 item=new OrderItem_24162049();item.setOrderItemId(r.getLong("OrderItemId"));item.setOrderId(orderId);item.setVideoId(r.getString("VideoId"));item.setTitle(r.getString("Title"));item.setPoster(r.getString("Poster"));item.setUnitPrice(r.getBigDecimal("UnitPrice"));item.setQuantity(r.getInt("Quantity"));order.getItems().add(item);}}}
   return order;
  }catch(SQLException e){throw new DataAccessException_24162049(e);}
 }
 private Order_24162049 mapOrder(ResultSet r)throws SQLException{Order_24162049 o=new Order_24162049();o.setOrderId(r.getLong("OrderId"));o.setUsername(r.getString("Username"));o.setRecipientName(r.getString("RecipientName"));o.setPhone(r.getString("Phone"));o.setAddress(r.getString("Address"));o.setNote(r.getString("Note"));o.setPaymentMethod(r.getString("PaymentMethod"));o.setStatus(r.getString("Status"));o.setTotalAmount(r.getBigDecimal("TotalAmount"));Timestamp created=r.getTimestamp("CreatedAt"),updated=r.getTimestamp("UpdatedAt");if(created!=null)o.setCreatedAt(created.toLocalDateTime());if(updated!=null)o.setUpdatedAt(updated.toLocalDateTime());return o;}
}
