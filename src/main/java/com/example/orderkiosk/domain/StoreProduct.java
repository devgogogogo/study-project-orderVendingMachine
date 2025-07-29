package com.example.orderkiosk.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "store_products")
public class StoreProduct {

    @Id
    private String storeProductId;

    @Column
    private String StoreId;

    @Column
    private String productId;

    @Column
    private String stockQuantity;

}
