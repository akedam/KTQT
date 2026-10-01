package vn.edu.huy.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem_24162049 implements Serializable {
 private static final long serialVersionUID=1L;
 private Video_24162049 product;
 private int quantity;
 public CartItem_24162049(Video_24162049 product,int quantity){this.product=product;this.quantity=quantity;}
 public Video_24162049 getProduct(){return product;}
 public void setProduct(Video_24162049 value){product=value;}
 public int getQuantity(){return quantity;}
 public void setQuantity(int value){quantity=value;}
 public BigDecimal getLineTotal(){return product.getPrice().multiply(BigDecimal.valueOf(quantity));}
}
