package com.example.orderkiosk.controller;

import com.example.orderkiosk.domain.CreateOrder;
import com.example.orderkiosk.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/api/v1/orders")
    public Response<Void> newOrder(
            @RequestBody NewOrderRequest request
    ) {

        orderService.newOrder(
                CreateOrder.builder()
                        .customerId(request.getCustomerId())
                        .storeId(request.getStoreId())
                        .quantityByProduct(request.getProducts())
                        .build()
        );
        return Response.success(null);
    }
}
