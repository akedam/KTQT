package vn.edu.huy.model;
import java.math.BigDecimal;
public class Video_24162049 implements java.io.Serializable {
 private static final long serialVersionUID=1L;
 private String videoId;
 public String getVideoId() { return videoId; }
 public void setVideoId(String value) { this.videoId=value; }
 private String title;
 public String getTitle() { return title; }
 public void setTitle(String value) { this.title=value; }
 private String poster;
 public String getPoster() { return poster; }
 public void setPoster(String value) { this.poster=value; }
 private int views;
 public int getViews() { return views; }
 public void setViews(int value) { this.views=value; }
 private String description;
 public String getDescription() { return description; }
 public void setDescription(String value) { this.description=value; }
 private boolean active;
 public boolean isActive() { return active; }
 public void setActive(boolean value) { this.active=value; }
 private int categoryId;
 public int getCategoryId() { return categoryId; }
 public void setCategoryId(int value) { this.categoryId=value; }
 private String categoryName;
 public String getCategoryName() { return categoryName; }
 public void setCategoryName(String value) { this.categoryName=value; }
 private int likes;
 public int getLikes() { return likes; }
 public void setLikes(int value) { this.likes=value; }
 private int shares;
 public int getShares() { return shares; }
 public void setShares(int value) { this.shares=value; }
 private BigDecimal price=BigDecimal.ZERO;
 public BigDecimal getPrice() { return price; }
 public void setPrice(BigDecimal value) { this.price=value==null?BigDecimal.ZERO:value; }
 private int stock;
 public int getStock() { return stock; }
 public void setStock(int value) { this.stock=value; }
}
