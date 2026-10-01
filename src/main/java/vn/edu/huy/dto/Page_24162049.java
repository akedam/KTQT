package vn.edu.huy.dto;

import java.util.*;
public class Page_24162049<T> {
 private final List<T> items; private final int total, currentPage, pageSize, totalPages;
 public Page_24162049(List<T> items,int total,int requested,int size){this.items=items;this.total=total;pageSize=size;totalPages=Math.max(1,(total+size-1)/size);currentPage=Math.min(Math.max(1,requested),totalPages);}
 public List<T> getItems(){return items;} public int getTotal(){return total;} public int getCurrentPage(){return currentPage;}
 public int getPageSize(){return pageSize;} public int getTotalPages(){return totalPages;} public int getOffset(){return (currentPage-1)*pageSize;}
 public static int clamp(int requested,int total,int size){return Math.min(Math.max(1,requested),Math.max(1,(total+size-1)/size));}
}
