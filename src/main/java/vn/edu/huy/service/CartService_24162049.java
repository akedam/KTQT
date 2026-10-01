package vn.edu.huy.service;

import java.math.BigDecimal;
import java.util.*;
import javax.servlet.http.HttpSession;
import vn.edu.huy.model.*;

public interface CartService_24162049 {
 List<CartItem_24162049> items(HttpSession session);
 void add(HttpSession session,String videoId,int quantity);
 void update(HttpSession session,String videoId,int quantity);
 void remove(HttpSession session,String videoId);
 void clear(HttpSession session);
 int totalQuantity(HttpSession session);
 BigDecimal total(HttpSession session);
}
