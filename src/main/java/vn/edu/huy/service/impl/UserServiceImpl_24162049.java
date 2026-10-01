package vn.edu.huy.service.impl;

import vn.edu.huy.model.*;import vn.edu.huy.dto.*;import vn.edu.huy.dao.*;import vn.edu.huy.dao.impl.*;import vn.edu.huy.service.*;import vn.edu.huy.validator.*;import org.mindrot.jbcrypt.BCrypt;
public class UserServiceImpl_24162049 implements UserService_24162049 {
 private final UserDao_24162049 dao=new UserDaoImpl_24162049();
 public User_24162049 find(String n){return dao.find(n);}
 public Page_24162049<User_24162049> page(String q,int requested){int count=dao.count(q);int page=Page_24162049.clamp(requested,count,6);return new Page_24162049<>(dao.page(q,(page-1)*6,6),count,page,6);}
 public void save(User_24162049 u,String password,boolean create,String actor){Validation_24162049.user(u);User_24162049 old=dao.find(u.getUsername());
 if(create)Validation_24162049.require(old==null,"Tên đăng nhập đã tồn tại.");else Validation_24162049.require(old!=null,"Người dùng không tồn tại.");
 Validation_24162049.require(!dao.emailExists(u.getEmail(),create?"":u.getUsername()),"Email đã được sử dụng.");
 if(!create&&u.getUsername().equalsIgnoreCase(actor))Validation_24162049.require(u.isAdmin()&&u.isActive(),"Bạn không thể tự bỏ quyền quản trị hoặc khóa tài khoản hiện tại.");
 if(create||!password.isEmpty()){Validation_24162049.password(password);u.setPassword(BCrypt.hashpw(password,BCrypt.gensalt(12)));}else u.setPassword(old.getPassword());
 if(create)dao.create(u);else dao.update(u);u.setPassword(null);
 }
 public void delete(String n,String actor){Validation_24162049.require(!n.equalsIgnoreCase(actor),"Bạn không thể tự xóa tài khoản đang đăng nhập.");dao.delete(n);}
}
