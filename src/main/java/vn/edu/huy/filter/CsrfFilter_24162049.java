package vn.edu.huy.filter;

import javax.servlet.*;import javax.servlet.http.*;import java.io.*;import java.nio.charset.StandardCharsets;import java.security.MessageDigest;
public class CsrfFilter_24162049 implements Filter {public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{HttpServletRequest r=(HttpServletRequest)req;if("POST".equals(r.getMethod())){String expected=(String)r.getSession().getAttribute("csrf"),actual=r.getParameter("csrf");if(expected==null||actual==null||!MessageDigest.isEqual(expected.getBytes(StandardCharsets.UTF_8),actual.getBytes(StandardCharsets.UTF_8))){((HttpServletResponse)res).sendError(403);return;}}chain.doFilter(req,res);}}
