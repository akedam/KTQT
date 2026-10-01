package vn.edu.huy.service.impl;

import java.math.BigDecimal;
import java.util.*;
import javax.servlet.http.HttpSession;
import vn.edu.huy.model.*;
import vn.edu.huy.service.*;

public class CartServiceImpl_24162049 implements CartService_24162049 {
 public static final int MAX_PER_ITEM=20;
 @SuppressWarnings("unchecked") private Map<String,CartItem_24162049> cart(HttpSession session){Object value=session.getAttribute("cart");if(value instanceof Map)return (Map<String,CartItem_24162049>)value;Map<String,CartItem_24162049> created=new LinkedHashMap<>();session.setAttribute("cart",created);return created;}
 public List<CartItem_24162049> items(HttpSession session){return new ArrayList<>(cart(session).values());}
 public void add(HttpSession session,String videoId,int quantity){Video_24162049 product=requireProduct(videoId);Map<String,CartItem_24162049> cart=cart(session);CartItem_24162049 current=cart.get(videoId);int requested=(current==null?0:current.getQuantity())+Math.max(1,quantity);validateQuantity(product,requested);if(current==null)cart.put(videoId,new CartItem_24162049(product,requested));else{current.setProduct(product);current.setQuantity(requested);}sync(session);}
 public void update(HttpSession session,String videoId,int quantity){Map<String,CartItem_24162049> cart=cart(session);if(!cart.containsKey(videoId))throw new IllegalArgumentException("Sản phẩm không có trong giỏ hàng.");if(quantity<=0){cart.remove(videoId);sync(session);return;}Video_24162049 product=requireProduct(videoId);validateQuantity(product,quantity);cart.get(videoId).setProduct(product);cart.get(videoId).setQuantity(quantity);sync(session);}
 public void remove(HttpSession session,String videoId){cart(session).remove(videoId);sync(session);}
 public void clear(HttpSession session){cart(session).clear();sync(session);}
 public int totalQuantity(HttpSession session){return cart(session).values().stream().mapToInt(CartItem_24162049::getQuantity).sum();}
 public BigDecimal total(HttpSession session){return cart(session).values().stream().map(CartItem_24162049::getLineTotal).reduce(BigDecimal.ZERO,BigDecimal::add);}
 private Video_24162049 requireProduct(String id){Video_24162049 product=new VideoServiceImpl_24162049().detail(id,false);if(product==null||!product.isActive())throw new IllegalArgumentException("Sản phẩm không tồn tại hoặc đã ngừng bán.");return product;}
 private void validateQuantity(Video_24162049 product,int quantity){int allowed=Math.min(MAX_PER_ITEM,product.getStock());if(allowed<=0)throw new IllegalArgumentException("Sản phẩm đã hết hàng.");if(quantity<1||quantity>allowed)throw new IllegalArgumentException("Số lượng phải từ 1 đến "+allowed+".");}
 private void sync(HttpSession session){session.setAttribute("cartTotalQuantity",totalQuantity(session));}
}
