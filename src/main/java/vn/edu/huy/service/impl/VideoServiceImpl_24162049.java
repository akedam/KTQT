package vn.edu.huy.service.impl;

import vn.edu.huy.model.*;import vn.edu.huy.dto.*;import vn.edu.huy.dao.*;import vn.edu.huy.dao.impl.*;import vn.edu.huy.service.*;
public class VideoServiceImpl_24162049 implements VideoService_24162049 {
 private final VideoDao_24162049 dao=new VideoDaoImpl_24162049();
 public Page_24162049<Video_24162049> page(int cat,int requested){int count=dao.count(cat);int p=Page_24162049.clamp(requested,count,3);return new Page_24162049<>(dao.page(cat,(p-1)*3,3),count,p,3);}
 public Video_24162049 detail(String id,boolean increment){return dao.detail(id,increment);}
}
