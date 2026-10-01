package vn.edu.huy.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem_24162049 implements Serializable {
 private static final long serialVersionUID=1L;
 private long orderItemId,orderId;
 private String videoId,title,poster;
 private BigDecimal unitPrice=BigDecimal.ZERO;
 private int quantity;
 public long getOrderItemId(){return orderItemId;} public void setOrderItemId(long v){orderItemId=v;}
 public long getOrderId(){return orderId;} public void setOrderId(long v){orderId=v;}
 public String getVideoId(){return videoId;} public void setVideoId(String v){videoId=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getPoster(){return poster;} public void setPoster(String v){poster=v;}
 public BigDecimal getUnitPrice(){return unitPrice;} public void setUnitPrice(BigDecimal v){unitPrice=v;}
 public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public BigDecimal getLineTotal(){return unitPrice.multiply(BigDecimal.valueOf(quantity));}
}
