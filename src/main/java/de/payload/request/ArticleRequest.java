package de.payload.request;

public class ArticleRequest {
  private Long id;
  private String name;
  private float price;
  private Long depotId;
  private boolean backup;
  private String ean;
  private String notice;

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

  public Long getDepotId() {
    return depotId;
  }

  public void setDepotId(Long depotId) {
    this.depotId = depotId;
  }

  public boolean isBackup() {
    return backup;
  }

  public void setBackup(boolean backup) {
    this.backup = backup;
  }

  public String getEan() {
    return ean;
  }

  public void setEan(String ean) {
    this.ean = ean;
  }

  public String getNotice() {
    return notice;
  }

  public void setNotice(String notice) {
    this.notice = notice;
  }
}
