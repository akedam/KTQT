package vn.edu.huy.dao.impl;

import java.sql.*;import java.util.*;import vn.edu.huy.dao.*;import vn.edu.huy.model.*;import vn.edu.huy.util.*;
public class CategoryDaoImpl_24162049 implements CategoryDao_24162049 {
 public List<Category_24162049> activeWithCounts(){String sql="SELECT c.*,COALESCE(v.Total,0) AS Total FROM Category c LEFT JOIN (SELECT CategoryId,COUNT(*) Total FROM Videos WHERE Active=1 GROUP BY CategoryId) v ON c.CategoryId=v.CategoryId WHERE c.Status=1 ORDER BY c.CategoryId";
 try(Connection c=ConnectionUtil_24162049.getConnection();PreparedStatement p=c.prepareStatement(sql);ResultSet r=p.executeQuery()){List<Category_24162049> list=new ArrayList<>();while(r.next()){Category_24162049 x=new Category_24162049();x.setCategoryId(r.getInt("CategoryId"));x.setCategoryName(r.getString("CategoryName"));x.setCategoryCode(r.getString("CategoryCode"));x.setImages(r.getString("Images"));x.setStatus(r.getBoolean("Status"));x.setVideoCount(r.getInt("Total"));list.add(x);}return list;}catch(SQLException e){throw new DataAccessException_24162049(e);}}
}
