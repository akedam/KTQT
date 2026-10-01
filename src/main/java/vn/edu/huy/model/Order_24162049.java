package vn.edu.huy.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Order_24162049 implements Serializable {
 private static final long serialVersionUID=1L;
 private long orderId;
 private String username,recipientName,phone,address,note,paymentMethod,status;
 private BigDecimal totalAmount=BigDecimal.ZERO;
 private LocalDateTime createdAt,updatedAt;
 private List<OrderItem_24162049> items=new ArrayList<>();
 public long getOrderId(){return orderId;} public void setOrderId(long v){orderId=v;}
 public String getUsername(){return username;} public void setUsername(String v){username=v;}
 public String getRecipientName(){return recipientName;} public void setRecipientName(String v){recipientName=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getAddress(){return address;} public void setAddress(String v){address=v;}
 public String getNote(){return note;} public void setNote(String v){note=v;}
 public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public String getStatusLabel(){try{return OrderStatus_24162049.fromCode(status).getLabel();}catch(Exception e){return status;}}
 public BigDecimal getTotalAmount(){return totalAmount;} public void setTotalAmount(BigDecimal v){totalAmount=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime v){updatedAt=v;}
 public List<OrderItem_24162049> getItems(){return items;} public void setItems(List<OrderItem_24162049> v){items=v;}
}
