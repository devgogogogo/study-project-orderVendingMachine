package com.example.orderkiosk.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Getter
@Table(name = "orders")
public class Order {
    @Id
    private int orderId;

    @Column
    private int customerId;

    @Column
    private Timestamp orderedAt;

    @MappedCollection(idColumn = "order_id", keyColumn = "order_item_id")
    private Set<OrderItem> orderItems = new HashSet<>();


    public Order(int customerId, Set<OrderItem> orderItems) {
        this.customerId = customerId;
        this.orderedAt = Timestamp.valueOf(LocalDateTime.now());
        this.orderItems = orderItems;
    }

    public static Order newOrder(CreateOrder creatOrder) {
        Set<OrderItem> items = new HashSet<>();
        for (Map.Entry<Integer,Integer> entry: creatOrder.getQuantityByProduct().entrySet()) {
            items.add(new OrderItem(entry.getKey(), entry.getValue()));
        }
        return new Order(creatOrder.getCustomerId(), items);
    }
}
