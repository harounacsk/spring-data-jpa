package de.payload.response;

public class ArticlePriceResponse {
  private Long id;
  private String articleName;
  private String distributorName;
  private float price;

  public ArticlePriceResponse(Long id, String articleName, String distributorName, float price) {
    this.id = id;
    this.articleName = articleName;
    this.distributorName = distributorName;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getArticleName() {
    return articleName;
  }

  public void setArticleName(String articleName) {
    this.articleName = articleName;
  }

  public String getDistributorName() {
    return distributorName;
  }

  public void setDistributorName(String distributorName) {
    this.distributorName = distributorName;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
