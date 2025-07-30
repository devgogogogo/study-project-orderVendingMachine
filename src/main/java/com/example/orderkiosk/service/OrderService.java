package com.example.orderkiosk.service;

import com.example.orderkiosk.domain.CreateOrder;
import com.example.orderkiosk.domain.Order;
import com.example.orderkiosk.domain.StoreProduct;
import com.example.orderkiosk.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

public class OrderService {
    private final OrderRepository orderRepository;
    private final StoreService storeService;

    public OrderService(OrderRepository orderRepository, StoreService storeService) {
        this.orderRepository = orderRepository;
        this.storeService = storeService;
    }

    public void newOrder(CreateOrder creatOrder) {
        List<StoreProduct> storeProducts = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : creatOrder.getQuantityByProduct().entrySet()) {
            Integer productId = entry.getKey();
            Integer buyQuantity = entry.getValue();

            StoreProduct storeProduct = storeService.getStoreProduct(
                    creatOrder.getStoreId(),
                    productId
            );

            int stockQuantity = storeProduct.getStockQuantity();

            if (buyQuantity > stockQuantity) {
                throw new RuntimeException("재고가 없습니다.");
            }
            storeProduct.adjustStockQuantity(buyQuantity);
            storeProducts.add(storeProduct);
        }
        Order entity = Order.newOrder(creatOrder);
        orderRepository.save(entity);

        storeService.saveAll(storeProducts);

    }
}
