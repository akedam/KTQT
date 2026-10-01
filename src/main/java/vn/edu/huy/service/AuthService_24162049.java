package vn.edu.huy.service;
import vn.edu.huy.model.*;import vn.edu.huy.dto.*;
public interface AuthService_24162049 {User_24162049 login(String name,String password); void validateRegistration(User_24162049 u,String password,String confirm); void activate(User_24162049 user);}
