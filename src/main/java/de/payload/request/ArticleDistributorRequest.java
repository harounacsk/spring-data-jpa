package de.payload.request;

import lombok.Data;

@Data
public class ArticleDistributorRequest {
  private Long id;
  private Long articleId;
  private Long distributorId;
  private float price;
  private float tax;
}
