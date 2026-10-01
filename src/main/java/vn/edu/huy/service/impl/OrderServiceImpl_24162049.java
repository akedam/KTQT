package vn.edu.huy.service.impl;

import java.util.*;
import vn.edu.huy.dao.*;
import vn.edu.huy.dao.impl.*;
import vn.edu.huy.model.*;
import vn.edu.huy.service.*;
import vn.edu.huy.validator.*;

public class OrderServiceImpl_24162049 implements OrderService_24162049 {
 private final OrderDao_24162049 dao=new OrderDaoImpl_24162049();
 public long checkout(String username,String recipientName,String phone,String address,String note,Collection<CartItem_24162049> items){recipientName=clean(recipientName);phone=clean(phone);address=clean(address);note=clean(note);Validation_24162049.require(username!=null&&!username.isBlank(),"Vui lòng đăng nhập để đặt hàng.");Validation_24162049.require(!items.isEmpty(),"Giỏ hàng đang trống.");Validation_24162049.require(recipientName.length()>=2&&recipientName.length()<=100,"Tên người nhận từ 2 đến 100 ký tự.");Validation_24162049.require(phone.matches("0[0-9]{9,10}"),"Số điện thoại không hợp lệ.");Validation_24162049.require(address.length()>=10&&address.length()<=300,"Địa chỉ nhận hàng từ 10 đến 300 ký tự.");Validation_24162049.require(note.length()<=500,"Ghi chú tối đa 500 ký tự.");return dao.create(username,recipientName,phone,address,note,items);}
 public List<Order_24162049> history(String username,String status){OrderStatus_24162049 parsed=OrderStatus_24162049.fromCode(status);return dao.list(username,parsed==null?"":parsed.getCode());}
 public Order_24162049 detail(String username,long orderId){return dao.find(username,orderId);}
 private String clean(String value){return value==null?"":value.trim();}
}
