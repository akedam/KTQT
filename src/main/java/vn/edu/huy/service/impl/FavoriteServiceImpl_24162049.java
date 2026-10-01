package vn.edu.huy.service.impl;

import vn.edu.huy.dao.*;import vn.edu.huy.dao.impl.*;import vn.edu.huy.service.*;import vn.edu.huy.validator.*;
public class FavoriteServiceImpl_24162049 implements FavoriteService_24162049 {
 private final FavoriteDao_24162049 dao=new FavoriteDaoImpl_24162049();
 public boolean exists(String u,String id){return dao.exists(u,id);}
 public void set(String u,String id,boolean liked){Validation_24162049.require(new VideoServiceImpl_24162049().detail(id,false)!=null,"Video không tồn tại hoặc đã ngừng hoạt động.");dao.set(u,id,liked);}
}
