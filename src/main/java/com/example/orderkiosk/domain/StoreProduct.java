package com.example.orderkiosk.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "store_products")
@Entity
public class StoreProduct {

    @Id
    private int storeProductId;

    @Column
    private int storeId;

    @Column
    private int productId;

    @Column
    private int stockQuantity;

    public void adjustStockQuantity(int buyQuantity) {
        if (stockQuantity < buyQuantity) {
            throw new RuntimeException("재고보다 많을 수 없습니다.");
        }
        this.stockQuantity = this.stockQuantity - buyQuantity;
    }

    @Builder
    public StoreProduct(int storeProductId, int storeId, int productId, int stockQuantity) {
        this.storeProductId = storeProductId;
        this.storeId = storeId;
        this.productId = productId;
        this.stockQuantity = stockQuantity;
    }
}


