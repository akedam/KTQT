package vn.edu.huy.util;

import javax.servlet.*;import javax.servlet.http.*;import java.io.*;import vn.edu.huy.model.*;import vn.edu.huy.validator.*;
public final class Web_24162049 {
 private Web_24162049(){}
 public static String param(HttpServletRequest r,String key){return Validation_24162049.text(r.getParameter(key));}
 public static int number(HttpServletRequest r,String key,int fallback){try{return Integer.parseInt(r.getParameter(key));}catch(Exception e){return fallback;}}
 public static void view(HttpServletRequest r,HttpServletResponse s,String name)throws ServletException,IOException{r.getRequestDispatcher("/WEB-INF/views/"+name+".jsp").forward(r,s);}
 public static void redirect(HttpServletRequest r,HttpServletResponse s,String path)throws IOException{s.sendRedirect(r.getContextPath()+path);}
 public static void flash(HttpServletRequest r,String message){r.getSession().setAttribute("flash",message);}
 public static User_24162049 current(HttpServletRequest r){return (User_24162049)r.getSession().getAttribute("user");}
 public static User_24162049 userForm(HttpServletRequest r){User_24162049 u=new User_24162049();u.setUsername(param(r,"username"));u.setFullname(param(r,"fullname"));u.setEmail(param(r,"email").toLowerCase(java.util.Locale.ROOT));u.setPhone(param(r,"phone"));u.setImages(param(r,"images"));u.setAdmin("on".equals(param(r,"admin")));u.setActive("on".equals(param(r,"active")));return u;}
 public static String encode(String s){return java.net.URLEncoder.encode(s,java.nio.charset.StandardCharsets.UTF_8);}
}
