package vn.edu.huy.util;

import java.util.*; import java.nio.file.*; import java.io.*;
public final class Config_24162049 {
 private static final Properties FILE=new Properties();
 static {String path=System.getProperty("APP_CONFIG");if(path==null||path.isBlank())path=System.getenv("APP_CONFIG");if(path!=null&&!path.isBlank())try(InputStream in=Files.newInputStream(Path.of(path))){FILE.load(new InputStreamReader(in,java.nio.charset.StandardCharsets.UTF_8));}catch(IOException e){throw new ExceptionInInitializerError("Không đọc được APP_CONFIG");}}
 private Config_24162049(){}
 public static String get(String key,String fallback){String v=System.getProperty(key);if(v==null)v=System.getenv(key);if(v==null)v=FILE.getProperty(key);return v==null?fallback:v;}
 public static String required(String key){String v=get(key,"");if(v.isBlank())throw new IllegalStateException("Chưa cấu hình "+key);return v;}
}
