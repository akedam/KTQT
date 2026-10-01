package vn.edu.huy.filter;

import javax.servlet.*;import javax.servlet.http.*;import java.io.*;
public class EncodingFilter_24162049 implements Filter {
 public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{req.setCharacterEncoding("UTF-8");res.setCharacterEncoding("UTF-8");HttpServletResponse s=(HttpServletResponse)res;s.setHeader("X-Content-Type-Options","nosniff");s.setHeader("X-Frame-Options","DENY");s.setHeader("Referrer-Policy","same-origin");s.setHeader("Content-Security-Policy","default-src 'self'; img-src 'self' https: data:; style-src 'self'; script-src 'self'; media-src 'self' https:; frame-ancestors 'none'; form-action 'self'; base-uri 'self'");chain.doFilter(req,res);}
}
