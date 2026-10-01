package vn.edu.huy.dao;

import java.util.*;import vn.edu.huy.model.*;
public interface UserDao_24162049 {
 User_24162049 find(String username); boolean emailExists(String email,String excluding); int count(String q);List<User_24162049> page(String q,int offset,int limit);
 void create(User_24162049 user);void update(User_24162049 user);void delete(String username);
}
