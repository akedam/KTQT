package vn.edu.huy.dto;

import vn.edu.huy.model.*;
public class PendingRegistration_24162049 implements java.io.Serializable {
 private static final long serialVersionUID=1L;
 public User_24162049 user;public String otpHash;public long expiresAt,sentAt;public int attempts;
 public String getEmail(){return user.getEmail();}public long getSentAt(){return sentAt;}
}
