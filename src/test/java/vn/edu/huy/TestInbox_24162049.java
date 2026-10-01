package vn.edu.huy;
import com.sun.net.httpserver.HttpServer;import java.net.*;import java.nio.charset.StandardCharsets;import javax.mail.internet.MimeMessage;
/** Read-only mailbox for local demo; loopback only, never packaged inside production WAR. */
public class TestInbox_24162049 {
 private static String escape(String s){return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;").replace("\"","&quot;");}
 public static void start()throws Exception{
  HttpServer http=HttpServer.create(new InetSocketAddress("127.0.0.1",8025),0);
  http.createContext("/",exchange->{StringBuilder html=new StringBuilder("<!doctype html><html lang='vi'><meta charset='UTF-8'><meta name='viewport' content='width=device-width,initial-scale=1'><title>Hộp thư thử Huy Video</title><style>body{font:15px Segoe UI,sans-serif;color:#17233e;background:#f7f9fc;max-width:850px;margin:60px auto;padding:0 25px}h1{font-size:35px}article{background:white;border:1px solid #e0e7ef;border-radius:12px;padding:25px;margin:20px 0}pre{white-space:pre-wrap;font:15px Segoe UI;line-height:1.8}small,p{color:#79859a}a{color:#315cf5}span{font-size:11px;letter-spacing:2px;color:#315cf5}</style><span>LOCAL DEVELOPMENT ONLY</span><h1>Hộp thư kiểm thử.</h1><p>Email được nhận bởi SMTP cục bộ, không gửi ra Internet. Hộp thư này chỉ dùng cho dữ liệu giả.</p><a href='/'>Làm mới hộp thư ↻</a>");
   try{MimeMessage[] messages=LocalRuntime_24162049.mail.getReceivedMessages();if(messages.length==0)html.append("<article>Chưa có email. Hãy đăng ký hoặc chia sẻ một video trên website.</article>");for(int i=messages.length-1;i>=0;i--){MimeMessage m=messages[i];html.append("<article><small>Đến: ").append(escape(java.util.Arrays.toString(m.getAllRecipients()))).append("</small><h2>").append(escape(m.getSubject())).append("</h2><pre>").append(escape(m.getContent().toString())).append("</pre></article>");}}catch(Exception e){html.append("<article>Không đọc được thư.</article>");}
   html.append("<p>Nguyễn Quốc Gia Huy · 24162049 · Mã đề 04</p></html>");byte[] bytes=html.toString().getBytes(StandardCharsets.UTF_8);exchange.getResponseHeaders().set("Content-Type","text/html; charset=UTF-8");exchange.getResponseHeaders().set("Cache-Control","no-store");exchange.sendResponseHeaders(200,bytes.length);try(var out=exchange.getResponseBody()){out.write(bytes);}
  });http.start();
 }
}
