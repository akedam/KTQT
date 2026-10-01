package vn.edu.huy;
import java.nio.file.*;
import java.sql.*;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;
import org.apache.catalina.webresources.*;
import com.icegreen.greenmail.util.*;
import vn.edu.huy.util.ConnectionUtil_24162049;
/** Local-only test launcher: Tomcat 9 + H2 + in-process SMTP. Not included in WAR. */
public class LocalRuntime_24162049 {
 public static GreenMail mail;
 public static Tomcat start(int port,boolean memory)throws Exception {
  Files.createDirectories(Path.of(".runtime"));
  System.setProperty("DB_URL",memory?"jdbc:h2:mem:integration;MODE=MSSQLServer;DATABASE_TO_UPPER=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;IGNORECASE=TRUE;DB_CLOSE_DELAY=-1":"jdbc:h2:file:./.runtime/video;MODE=MSSQLServer;DATABASE_TO_UPPER=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;IGNORECASE=TRUE;AUTO_SERVER=TRUE");
  System.setProperty("DB_USER","sa");System.setProperty("DB_PASSWORD","");
  System.setProperty("SMTP_HOST","127.0.0.1");System.setProperty("SMTP_PORT",memory?"3026":"3025");System.setProperty("SMTP_AUTH","false");System.setProperty("SMTP_STARTTLS","false");System.setProperty("SMTP_FROM","hello@huyvideo.test");System.setProperty("APP_BASE_URL","http://localhost:"+port+"/video-24162049");
  try(Connection c=ConnectionUtil_24162049.getConnection()){
   boolean exists;try(ResultSet r=c.getMetaData().getTables(null,null,"Users",null)){exists=r.next();}
   if(!exists){runSql(c,Files.readString(Path.of("src/test/resources/schema-h2.sql")));runSql(c,Files.readString(Path.of("src/test/resources/seed-h2.sql")));}
  }
  mail=new GreenMail(new ServerSetup(memory?3026:3025,"127.0.0.1",ServerSetup.PROTOCOL_SMTP));mail.getManagers().getUserManager().setAuthRequired(false);mail.start();
  Tomcat t=new Tomcat();t.setBaseDir(Path.of(".runtime/tomcat-"+port).toAbsolutePath().toString());t.setPort(port);t.getConnector().setProperty("address","127.0.0.1");
  Context ctx=t.addWebapp("/video-24162049",Path.of("src/main/webapp").toAbsolutePath().toString());ctx.setParentClassLoader(LocalRuntime_24162049.class.getClassLoader());
  StandardRoot resources=new StandardRoot(ctx);resources.addPreResources(new DirResourceSet(resources,"/WEB-INF/classes",Path.of("target/classes").toAbsolutePath().toString(),"/"));ctx.setResources(resources);
  t.start();return t;
 }
 public static void runSql(Connection c,String text)throws SQLException {for(String s:text.replaceAll("(?m)^--.*$","").split(";")){if(!s.isBlank())try(PreparedStatement p=c.prepareStatement(s)){p.execute();}}}
 public static void main(String[] args)throws Exception{Tomcat t=start(8080,false);TestInbox_24162049.start();System.out.println("Local preview: http://localhost:8080/video-24162049/home (H2 + local test SMTP; not SQL Server). Test inbox: http://localhost:8025");t.getServer().await();}
}
