package vn.edu.huy.controller;

import javax.servlet.*;import javax.servlet.http.*;import java.io.*;import vn.edu.huy.model.*;import vn.edu.huy.util.*;import vn.edu.huy.service.impl.*;
public class AuthController_24162049 extends HttpServlet {
 private final AuthServiceImpl_24162049 auth=new AuthServiceImpl_24162049();private final OtpServiceImpl_24162049 otp=new OtpServiceImpl_24162049();
 protected void doGet(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{String path=r.getServletPath();if(path.equals("/logout")||path.equals("/resend-otp")){s.sendError(405);return;}if(path.equals("/verify-otp")&&r.getSession().getAttribute("pending")==null){Web_24162049.flash(r,"Vui lòng điền thông tin đăng ký trước.");Web_24162049.redirect(r,s,"/register");return;}Web_24162049.view(r,s,path.equals("/verify-otp")?"otp":path.substring(1));}
 protected void doPost(HttpServletRequest r,HttpServletResponse s)throws ServletException,IOException{String path=r.getServletPath();try{switch(path){
 case "/login": {HttpSession session=r.getSession();long now=System.currentTimeMillis();Long until=(Long)session.getAttribute("loginLockedUntil");if(until!=null&&now<until)throw new IllegalArgumentException("Quá nhiều lần đăng nhập sai. Vui lòng thử lại sau 60 giây.");User_24162049 u;try{u=auth.login(Web_24162049.param(r,"username"),r.getParameter("password"));}catch(IllegalArgumentException e){Integer count=(Integer)session.getAttribute("loginAttempts");count=count==null?1:count+1;session.setAttribute("loginAttempts",count);if(count>=5){session.setAttribute("loginLockedUntil",now+60000);session.setAttribute("loginAttempts",0);}throw e;}session.invalidate();r.getSession(true).setAttribute("user",u);Web_24162049.redirect(r,s,u.isAdmin()?"/admin":"/home");break;}
 case "/logout":r.getSession().invalidate();Web_24162049.redirect(r,s,"/login");break;
 case "/register": {User_24162049 u=Web_24162049.userForm(r);r.setAttribute("form",u);auth.validateRegistration(u,r.getParameter("password"),r.getParameter("confirm"));otp.begin(r.getSession(),u);Web_24162049.flash(r,"OTP đã được gửi. Vui lòng kiểm tra hộp thư của bạn.");Web_24162049.redirect(r,s,"/verify-otp");break;}
 case "/verify-otp":otp.verify(r.getSession(),Web_24162049.param(r,"otp"));Web_24162049.flash(r,"Xác minh thành công! Bạn có thể đăng nhập.");Web_24162049.redirect(r,s,"/login");break;
 case "/resend-otp":otp.resend(r.getSession());Web_24162049.flash(r,"Mã OTP mới đã được gửi đến email của bạn.");Web_24162049.redirect(r,s,"/verify-otp");break;
 default:s.sendError(404);
 }}catch(IllegalArgumentException e){r.setAttribute("error",e.getMessage());if(path.equals("/resend-otp")){Web_24162049.flash(r,e.getMessage());Web_24162049.redirect(r,s,"/verify-otp");}else Web_24162049.view(r,s,path.equals("/verify-otp")?"otp":path.substring(1));}}
}
