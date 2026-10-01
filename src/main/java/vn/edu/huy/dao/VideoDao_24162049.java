package vn.edu.huy.dao;

import java.util.*;import vn.edu.huy.model.*;
public interface VideoDao_24162049 {int count(int category);List<Video_24162049> page(int category,int offset,int limit);Video_24162049 detail(String id,boolean increment);String create(Video_24162049 video);}
