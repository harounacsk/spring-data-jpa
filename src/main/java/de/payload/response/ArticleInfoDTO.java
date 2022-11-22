package de.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleInfoDTO {
  private Long id;
  private String name;
  private float price;
  private boolean backup;
  private String notice;
  private Long quantity;
}
