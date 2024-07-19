package com.devstack.ecom.feanix.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestProductDto {
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
