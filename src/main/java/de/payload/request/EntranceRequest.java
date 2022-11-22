package de.payload.request;

import lombok.Data;

@Data
public class EntranceRequest {
  private Long id;
  private Long articleId;
  private int quantity;
  private String notice;
}
