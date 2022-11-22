package de.payload.response;

public class ArticleDTO {
  /**
   *  a.id, a.name,a.price,d.notice
   */
  private Long id;
  private  String name;
  private float price;
  private String notice;

  public ArticleDTO(Long id, String name, float price, String notice) {
    this.id = id;
    this.name = name;
    this.price=price;
    this.notice = notice;
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

  public String getNotice() {
    return notice;
  }

  public void setNotice(String notice) {
    this.notice = notice;
  }
}
