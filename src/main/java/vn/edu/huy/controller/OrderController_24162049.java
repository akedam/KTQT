package vn.edu.huy.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vn.edu.huy.model.*;
import vn.edu.huy.service.impl.*;
import vn.edu.huy.util.*;

public class OrderController_24162049 extends HttpServlet {
 private final OrderServiceImpl_24162049 service=new OrderServiceImpl_24162049();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{String username=Web_24162049.current(r).getUsername();try{if(r.getServletPath().equals("/orders/detail")){long id;try{id=Long.parseLong(r.getParameter("id"));}catch(Exception e){s.sendError(404);return;}Order_24162049 order=service.detail(username,id);if(order==null){s.sendError(404);return;}r.setAttribute("order",order);Web_24162049.view(r,s,"order-detail");return;}String status=Web_24162049.param(r,"status");r.setAttribute("selectedStatus",status);r.setAttribute("statuses",OrderStatus_24162049.all());r.setAttribute("orders",service.history(username,status));Web_24162049.view(r,s,"orders");}catch(IllegalArgumentException e){s.sendError(400);}}
}
