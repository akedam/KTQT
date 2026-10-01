package vn.edu.huy.filter;

import javax.servlet.*;import javax.servlet.http.*;import java.io.*;import java.util.*;import vn.edu.huy.model.*;import vn.edu.huy.service.impl.*;import vn.edu.huy.util.*;
public class AuthenticationFilter_24162049 implements Filter {
 public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{
 HttpServletRequest r=(HttpServletRequest)req;HttpServletResponse s=(HttpServletResponse)res;String path=r.getServletPath();if(path.startsWith("/assets/")){chain.doFilter(req,res);return;}
 s.setHeader("Cache-Control","no-store");HttpSession session=r.getSession();if(session.getAttribute("csrf")==null)session.setAttribute("csrf",UUID.randomUUID().toString());
 User_24162049 u=(User_24162049)session.getAttribute("user");
 try{if(u!=null){User_24162049 fresh=new UserServiceImpl_24162049().find(u.getUsername());if(fresh==null||!fresh.isActive()){session.removeAttribute("user");u=null;}else{fresh.setPassword(null);session.setAttribute("user",fresh);u=fresh;}}}catch(DataAccessException_24162049 e){s.sendError(500);return;}
 boolean protectedPath=path.equals("/admin")||path.startsWith("/admin/")||path.equals("/video/like")||path.equals("/video/share")||path.equals("/checkout")||path.equals("/orders")||path.startsWith("/orders/");
 if(protectedPath&&u==null){Web_24162049.flash(r,"Vui lòng đăng nhập để tiếp tục.");Web_24162049.redirect(r,s,"/login");return;}
 Object flash=session.getAttribute("flash");if(flash!=null){r.setAttribute("flash",flash);session.removeAttribute("flash");}chain.doFilter(req,res);
 }
}
