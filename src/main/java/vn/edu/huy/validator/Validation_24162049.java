package vn.edu.huy.validator;

import vn.edu.huy.model.*;
public final class Validation_24162049 {
 private Validation_24162049(){}
 public static String text(String s){return s==null?"":s.trim();}
 public static void require(boolean ok,String message){if(!ok)throw new IllegalArgumentException(message);}
 public static void password(String s){require(s!=null&&s.length()>=8&&s.getBytes(java.nio.charset.StandardCharsets.UTF_8).length<=72,"Mật khẩu cần ít nhất 8 ký tự và không quá 72 byte UTF-8.");}
 public static void email(String s,int max){require(s!=null&&s.length()<=max&&s.matches("^[A-Za-z0-9.!#$%&'*+/=?^_`{|}~-]+@[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?(?:\\.[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?)+$"),"Địa chỉ email không hợp lệ hoặc quá dài.");}
 public static void user(User_24162049 u){require(u.getUsername()!=null&&u.getUsername().matches("[A-Za-z0-9_]{3,50}"),"Tên đăng nhập gồm 3–50 chữ, số hoặc dấu gạch dưới.");require(u.getFullname()!=null&&!u.getFullname().isBlank()&&u.getFullname().length()<=50,"Họ tên cần có 1–50 ký tự.");require(u.getPhone()!=null&&u.getPhone().matches("\\+?[0-9]{9,14}"),"Số điện thoại gồm 9–14 chữ số, có thể bắt đầu bằng +.");email(u.getEmail(),150);String img=u.getImages();require(img==null||img.isBlank()||(img.length()<=500&&img.matches("https://[^\\s<>\"']+")),"Ảnh phải là URL HTTPS hợp lệ, tối đa 500 ký tự.");}
}
