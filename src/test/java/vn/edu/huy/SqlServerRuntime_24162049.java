package vn.edu.huy;
import java.nio.file.Path;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;
/** Deploys the packaged WAR to real Tomcat 9, using APP_CONFIG and SQL Server. */
public class SqlServerRuntime_24162049 {
 public static void main(String[] args)throws Exception {
  int port=Integer.parseInt(System.getProperty("APP_PORT","8080"));
  java.nio.file.Files.createDirectories(Path.of(".runtime/tomcat-sql-"+port,"webapps"));
  Tomcat tomcat=new Tomcat();tomcat.setBaseDir(Path.of(".runtime/tomcat-sql-"+port).toAbsolutePath().toString());tomcat.setPort(port);tomcat.getConnector().setProperty("address","127.0.0.1");
  Context context=tomcat.addWebapp("/video-24162049",Path.of("target/video-24162049.war").toAbsolutePath().toString());context.setParentClassLoader(SqlServerRuntime_24162049.class.getClassLoader());((org.apache.catalina.core.StandardContext)context).setDelegate(true);
  tomcat.start();System.out.println("SQL Server application: http://localhost:"+port+"/video-24162049/home");tomcat.getServer().await();
 }
}
