package vn.edu.huy.filter;

import javax.servlet.*;import javax.servlet.http.*;import java.io.*;import vn.edu.huy.model.*;
public class AdminAuthorizationFilter_24162049 implements Filter {public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{HttpServletRequest r=(HttpServletRequest)req;User_24162049 u=(User_24162049)r.getSession().getAttribute("user");if(u==null||!u.isAdmin()){((HttpServletResponse)res).sendError(403);return;}chain.doFilter(req,res);}}
