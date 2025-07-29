package com.example.orderkiosk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(name = "order_items")
public class OrderItem {

    @Id
    private int orderItemId;

    @Column
    private int productId;

    @Column
    private int orderId;

    @Column
    private int orderQuantity;

    public OrderItem(int productId, int orderQuantity) {
        this.productId = productId;
        this.orderQuantity = orderQuantity;
    }
}
