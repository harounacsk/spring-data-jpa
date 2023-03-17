package de.payload.request;

import lombok.Data;

@Data
public class ArticleRequest {
  private Long id;
  private String name;
  private float price;
  private Long depot;
  private boolean backup;
  private String ean;
  private String notice;
}
