package vn.edu.huy.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vn.edu.huy.model.*;
import vn.edu.huy.service.impl.*;
import vn.edu.huy.util.*;

public class CheckoutController_24162049 extends HttpServlet {
 private final CartServiceImpl_24162049 cart=new CartServiceImpl_24162049();
 private final OrderServiceImpl_24162049 orders=new OrderServiceImpl_24162049();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{if(cart.items(r.getSession()).isEmpty()){Web_24162049.flash(r,"Giỏ hàng đang trống.");Web_24162049.redirect(r,s,"/cart");return;}User_24162049 user=Web_24162049.current(r);r.setAttribute("recipientName",user.getFullname());r.setAttribute("phone",user.getPhone());prepare(r);Web_24162049.view(r,s,"checkout");}
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{User_24162049 user=Web_24162049.current(r);String name=Web_24162049.param(r,"recipientName"),phone=Web_24162049.param(r,"phone"),address=Web_24162049.param(r,"address"),note=Web_24162049.param(r,"note");try{long id=orders.checkout(user.getUsername(),name,phone,address,note,cart.items(r.getSession()));cart.clear(r.getSession());Web_24162049.flash(r,"Đặt hàng COD thành công. Mã đơn #"+id+".");Web_24162049.redirect(r,s,"/orders/detail?id="+id);}catch(IllegalArgumentException e){r.setAttribute("error",e.getMessage());r.setAttribute("recipientName",name);r.setAttribute("phone",phone);r.setAttribute("address",address);r.setAttribute("note",note);prepare(r);Web_24162049.view(r,s,"checkout");}}
 private void prepare(HttpServletRequest r){r.setAttribute("items",cart.items(r.getSession()));r.setAttribute("cartTotal",cart.total(r.getSession()));}
}
