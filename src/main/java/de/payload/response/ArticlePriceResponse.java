package de.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticlePriceResponse {
  private Long id;
  private String articleName;
  private String distributorName;
  private float price;
}
