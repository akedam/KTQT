package vn.edu.huy.model;

import java.util.*;

public enum OrderStatus_24162049 {
 NEW("NEW","Đơn hàng mới"),
 CONFIRMED("CONFIRMED","Đã xác nhận"),
 PREPARING("PREPARING","Chuẩn bị hàng"),
 SHIPPING("SHIPPING","Vận chuyển"),
 DELIVERING("DELIVERING","Giao hàng"),
 DELIVERED("DELIVERED","Đã giao"),
 CANCELLED("CANCELLED","Đơn hàng hủy"),
 RETURNED("RETURNED","Đơn hàng hoàn");
 private final String code,label;
 OrderStatus_24162049(String code,String label){this.code=code;this.label=label;}
 public String getCode(){return code;}
 public String getLabel(){return label;}
 public static OrderStatus_24162049 fromCode(String value){
  if(value==null||value.isBlank())return null;
  for(OrderStatus_24162049 status:values())if(status.code.equalsIgnoreCase(value))return status;
  throw new IllegalArgumentException("Trạng thái đơn hàng không hợp lệ.");
 }
 public static List<OrderStatus_24162049> all(){return List.of(values());}
}
