package vn.edu.huy.service.impl;

import vn.edu.huy.model.*;import vn.edu.huy.dao.*;import vn.edu.huy.dao.impl.*;import vn.edu.huy.service.*;import vn.edu.huy.validator.*;import vn.edu.huy.util.*;
public class ShareServiceImpl_24162049 implements ShareService_24162049 {
 private final ShareDao_24162049 dao=new ShareDaoImpl_24162049();private final EmailService_24162049 mail=new EmailServiceImpl_24162049();
 public void share(String u,String id,String email){Validation_24162049.email(email,50);Video_24162049 v=new VideoServiceImpl_24162049().detail(id,false);Validation_24162049.require(v!=null,"Video không tồn tại hoặc đã ngừng hoạt động.");mail.send(email,"Một video dành cho bạn | Huy Video",u+" muốn chia sẻ với bạn: "+v.getTitle()+"\n"+Config_24162049.required("APP_BASE_URL")+"/video/detail?id="+java.net.URLEncoder.encode(id,java.nio.charset.StandardCharsets.UTF_8));dao.create(u,id,email);}
}
