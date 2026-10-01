package vn.edu.huy.dao;

import java.util.*;
import vn.edu.huy.model.*;

public interface OrderDao_24162049 {
 long create(String username,String recipientName,String phone,String address,String note,Collection<CartItem_24162049> items);
 List<Order_24162049> list(String username,String status);
 Order_24162049 find(String username,long orderId);
}
