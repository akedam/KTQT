package vn.edu.huy.service;

import java.util.*;
import vn.edu.huy.model.*;

public interface OrderService_24162049 {
 long checkout(String username,String recipientName,String phone,String address,String note,Collection<CartItem_24162049> items);
 List<Order_24162049> history(String username,String status);
 Order_24162049 detail(String username,long orderId);
}
