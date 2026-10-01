package vn.edu.huy.service.impl;

import java.util.*;import javax.mail.*;import javax.mail.internet.*;import vn.edu.huy.service.*;import vn.edu.huy.util.*;
public class EmailServiceImpl_24162049 implements EmailService_24162049 {
 public void send(String to,String subject,String content){
  Properties p=new Properties();p.setProperty("mail.smtp.host",Config_24162049.required("SMTP_HOST"));p.setProperty("mail.smtp.port",Config_24162049.get("SMTP_PORT","587"));p.setProperty("mail.smtp.auth",Config_24162049.get("SMTP_AUTH","true"));p.setProperty("mail.smtp.starttls.enable",Config_24162049.get("SMTP_STARTTLS","true"));p.setProperty("mail.smtp.starttls.required",Config_24162049.get("SMTP_STARTTLS","true"));p.setProperty("mail.smtp.ssl.checkserveridentity","true");p.setProperty("mail.smtp.connectiontimeout","10000");p.setProperty("mail.smtp.timeout","10000");p.setProperty("mail.smtp.writetimeout","10000");
  Session session=Session.getInstance(p,new Authenticator(){protected PasswordAuthentication getPasswordAuthentication(){return new PasswordAuthentication(Config_24162049.get("SMTP_USER",""),Config_24162049.get("SMTP_PASSWORD",""));}});session.setDebug(false);
  try{MimeMessage m=new MimeMessage(session);m.setFrom(new InternetAddress(Config_24162049.required("SMTP_FROM")));m.setRecipient(Message.RecipientType.TO,new InternetAddress(to,true));m.setSubject(subject,"UTF-8");m.setText(content,"UTF-8");Transport.send(m);}catch(MessagingException e){throw new IllegalArgumentException("Chưa gửi được email. Vui lòng kiểm tra cấu hình SMTP hoặc thử lại sau.");}
 }
}
