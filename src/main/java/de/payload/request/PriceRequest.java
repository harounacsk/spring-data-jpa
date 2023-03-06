package de.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceRequest {
    private Long priceId;
    private Long articleId;
    private Long distributorId;
    private float price;

}
