package com.devstack.ecom.feanix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "product_id", length = 80)
    private String productId;
    @Column(name = "description", length = 750, nullable = false)
    private String description;
    @Column(name = "unit_price", precision = 2, nullable = false)
    private double unitPrice;
    @Column(name = "qty_on_hand", nullable = false)
    private int qtyOnHand;
    @Embedded
    private FileResource FileResource;
}
