package com.example.orderkiosk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Table(name = "products")
public class Product {

    @Id
    private String productId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;
}
