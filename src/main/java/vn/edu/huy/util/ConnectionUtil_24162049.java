package vn.edu.huy.util;

import java.sql.*;
public final class ConnectionUtil_24162049 {
 private ConnectionUtil_24162049(){}
 public static Connection getConnection() throws SQLException {
  String url=Config_24162049.required("DB_URL");
  try{Class.forName(url.startsWith("jdbc:h2:")?"org.h2.Driver":"com.microsoft.sqlserver.jdbc.SQLServerDriver");}catch(ClassNotFoundException e){throw new SQLException("Thiếu JDBC driver",e);}
  return DriverManager.getConnection(url,Config_24162049.get("DB_USER",""),Config_24162049.get("DB_PASSWORD",""));
 }
}
