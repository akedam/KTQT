package vn.edu.huy.service.impl;

import java.util.*;import vn.edu.huy.model.*;import vn.edu.huy.dao.*;import vn.edu.huy.dao.impl.*;import vn.edu.huy.service.*;
public class CategoryServiceImpl_24162049 implements CategoryService_24162049 {private final CategoryDao_24162049 dao=new CategoryDaoImpl_24162049();public List<Category_24162049> active(){return dao.activeWithCounts();}}
