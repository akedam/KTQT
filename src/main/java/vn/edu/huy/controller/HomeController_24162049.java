package vn.edu.huy.controller;

import javax.servlet.*;import javax.servlet.http.*;import java.io.*;import vn.edu.huy.util.*;import vn.edu.huy.service.impl.*;
public class HomeController_24162049 extends HttpServlet {protected void doGet(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{r.setAttribute("categories",new CategoryServiceImpl_24162049().active());r.setAttribute("page",new VideoServiceImpl_24162049().page(0,1));Web_24162049.view(r,s,"home");}}
