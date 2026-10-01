package vn.edu.huy.service.impl;

import vn.edu.huy.model.*;import vn.edu.huy.dao.*;import vn.edu.huy.dao.impl.*;import vn.edu.huy.service.*;import vn.edu.huy.validator.*;import org.mindrot.jbcrypt.BCrypt;
public class AuthServiceImpl_24162049 implements AuthService_24162049 {
 private final UserDao_24162049 dao=new UserDaoImpl_24162049();
 private static final String DUMMY=BCrypt.hashpw("timing-only-dummy",BCrypt.gensalt(12));
 public User_24162049 login(String name,String password){User_24162049 u=dao.find(name);boolean ok=BCrypt.checkpw(password==null?"":password,u==null?DUMMY:u.getPassword());Validation_24162049.require(u!=null&&ok&&u.isActive(),"Tên đăng nhập, mật khẩu không đúng hoặc tài khoản chưa được kích hoạt.");u.setPassword(null);return u;}
 public void validateRegistration(User_24162049 u,String pass,String confirm){Validation_24162049.user(u);Validation_24162049.password(pass);Validation_24162049.require(pass.equals(confirm),"Xác nhận mật khẩu chưa khớp.");Validation_24162049.require(dao.find(u.getUsername())==null,"Tên đăng nhập đã tồn tại.");Validation_24162049.require(!dao.emailExists(u.getEmail(),""),"Email đã được sử dụng.");u.setPassword(BCrypt.hashpw(pass,BCrypt.gensalt(12)));u.setAdmin(false);u.setActive(false);}
 public void activate(User_24162049 u){u.setAdmin(false);u.setActive(true);dao.create(u);u.setPassword(null);}
}
