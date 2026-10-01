package vn.edu.huy.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vn.edu.huy.service.impl.*;
import vn.edu.huy.util.*;

public class CartController_24162049 extends HttpServlet {
 private final CartServiceImpl_24162049 service=new CartServiceImpl_24162049();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{if(!r.getServletPath().equals("/cart")){s.sendError(405);return;}show(r,s);}
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException,ServletException{
  String path=r.getServletPath(),id=Web_24162049.param(r,"id");
  try{
   if(path.equals("/cart/add")){service.add(r.getSession(),id,Web_24162049.number(r,"quantity",1));Web_24162049.flash(r,"Đã thêm sản phẩm vào giỏ hàng.");}
   else if(path.equals("/cart/update")){service.update(r.getSession(),id,Web_24162049.number(r,"quantity",1));Web_24162049.flash(r,"Đã cập nhật số lượng.");}
   else if(path.equals("/cart/remove")){service.remove(r.getSession(),id);Web_24162049.flash(r,"Đã xóa sản phẩm khỏi giỏ hàng.");}
   else{s.sendError(405);return;}
  }catch(IllegalArgumentException e){Web_24162049.flash(r,e.getMessage());}
  Web_24162049.redirect(r,s,"/cart");
 }
 private void show(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{r.setAttribute("items",service.items(r.getSession()));r.setAttribute("cartTotal",service.total(r.getSession()));r.setAttribute("maxPerItem",CartServiceImpl_24162049.MAX_PER_ITEM);Web_24162049.view(r,s,"cart");}
}
