package com.devstack.ecom.feanix.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
    @OneToMany(mappedBy = "product")
    private Set<CustomerOrderDetails> orderDetails = new HashSet<>();
}
