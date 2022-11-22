package de.payload.response;

public class ArticleInfoDTO {

  private Long id;
  private String name;
  private float price;
  private boolean backup;
  private String notice;
  private Long quantity;

  public ArticleInfoDTO(Long id, String name, float price, boolean backup, String notice, Long quantity) {
    this.id = id;
    this.name = name;
     this.price=price;
    this.backup = backup;
    this.notice = notice;
    this.quantity = quantity;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public boolean isBackup() {
    return backup;
  }

  public void setBackup(boolean backup) {
    this.backup = backup;
  }

  public String getNotice() {
    return notice;
  }

  public void setNotice(String notice) {
    this.notice = notice;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }
}
