package vn.edu.huy.service;
import vn.edu.huy.model.*;import vn.edu.huy.dto.*;
public interface UserService_24162049 {User_24162049 find(String name); Page_24162049<User_24162049> page(String q,int requested); void save(User_24162049 user,String password,boolean create,String actor); void delete(String name,String actor);}
