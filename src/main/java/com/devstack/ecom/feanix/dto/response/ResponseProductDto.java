package com.devstack.ecom.feanix.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseProductDto {
    private String productId;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
    private String resourceUrl;
}
