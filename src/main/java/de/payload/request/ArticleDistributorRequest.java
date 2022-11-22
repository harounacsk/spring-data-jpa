package de.payload.request;

public class ArticleDistributorRequest {
  private Long id;
  private Long articleId;
  private Long distributorId;

  public Long getId() {
    return id;
  }
  private float price;
  private float tax;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getArticleId() {
    return articleId;
  }

  public void setArticleId(Long articleId) {
    this.articleId = articleId;
  }

  public Long getDistributorId() {
    return distributorId;
  }

  public void setDistributorId(Long distributorId) {
    this.distributorId = distributorId;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public float getTax() {
    return tax;
  }

  public void setTax(float tax) {
    this.tax = tax;
  }
}
