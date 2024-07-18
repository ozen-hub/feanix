package com.devstack.ecom.feanix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity(name = "payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @Column(name = "payment_id", nullable = false)
    private String paymentId;
    @Column(name = "payment_type", nullable = false, length = 100)
    private String paymentType;
    @Column(name = "date", columnDefinition = "DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "transaction_id", length = 250, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private String transactionId;
    @Column(name = "amount", nullable = false)
    private double amount;
    @OneToOne
    @Column(nullable = false,unique = true, length = 80, name = "customer_order_id")
    private CustomerOrder customerOrder;
}
