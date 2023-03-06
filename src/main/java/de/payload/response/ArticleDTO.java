package de.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDTO {
    private Long id;
    private String name;
    private float price;
    private String notice;
}
