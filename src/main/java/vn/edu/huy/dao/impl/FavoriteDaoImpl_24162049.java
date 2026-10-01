package vn.edu.huy.dao.impl;

import java.sql.*;import vn.edu.huy.dao.*;import vn.edu.huy.util.*;
public class FavoriteDaoImpl_24162049 implements FavoriteDao_24162049 {
 public boolean exists(String u,String v){try(Connection c=ConnectionUtil_24162049.getConnection();PreparedStatement p=c.prepareStatement("SELECT COUNT(*) FROM Favorites WHERE Username=? AND VideoId=?")){p.setString(1,u);p.setString(2,v);try(ResultSet r=p.executeQuery()){r.next();return r.getInt(1)>0;}}catch(SQLException e){throw new DataAccessException_24162049(e);}}
 public void set(String u,String v,boolean liked){String sql=liked?"INSERT INTO Favorites(Username,VideoId,LikedDate) VALUES(?,?,?)":"DELETE FROM Favorites WHERE Username=? AND VideoId=?";
 try(Connection c=ConnectionUtil_24162049.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,u);p.setString(2,v);if(liked)p.setDate(3,Date.valueOf(java.time.LocalDate.now()));p.executeUpdate();}catch(SQLException e){if(liked&&(e.getErrorCode()==2627||e.getErrorCode()==2601||"23505".equals(e.getSQLState())))return;throw new DataAccessException_24162049(e);}}
}
