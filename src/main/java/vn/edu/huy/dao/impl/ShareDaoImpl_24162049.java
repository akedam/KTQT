package vn.edu.huy.dao.impl;

import java.sql.*;import vn.edu.huy.dao.*;import vn.edu.huy.util.*;
public class ShareDaoImpl_24162049 implements ShareDao_24162049 {
 public void create(String u,String v,String email){try(Connection c=ConnectionUtil_24162049.getConnection();PreparedStatement p=c.prepareStatement("INSERT INTO Shares(Username,VideoId,Emails,SharedDate) VALUES(?,?,?,?)")){p.setString(1,u);p.setString(2,v);p.setString(3,email);p.setDate(4,Date.valueOf(java.time.LocalDate.now()));p.executeUpdate();}catch(SQLException e){throw new DataAccessException_24162049(e);}}
}
