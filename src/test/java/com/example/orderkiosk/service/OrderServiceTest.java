//package com.example.orderkiosk.service;
//
//import com.example.orderkiosk.domain.CreateOrder;
//import com.example.orderkiosk.domain.StoreProduct;
//import com.example.orderkiosk.repository.OrderRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.HashMap;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class OrderServiceTest {
//
//    @Mock
//    OrderRepository orderRepository; //의존 객체
//
//    @Mock
//    StoreService storeService; //의존 객체
//
//    @InjectMocks
//    OrderService orderService; //테스트할 대상 객체
//
//    @Test
//    @DisplayName("구매 수량이 재고 수량보다 적을떄, 정상 주문이 가능하다.")
//    public void stockQuantityTest_euccess() {
//
//        //given
//        int buyQuantity = 5;
//        int stockQuantity = 50;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1, buyQuantity);
//        CreateOrder createOrder = CreateOrder.builder()
//                .storeId(1)
//                .customerId(1)
//                .quantityByProduct(map)
//                .build();
//        StoreProduct stock = StoreProduct.builder()
//                .stockQuantity(stockQuantity)
//                .build();
//
//        when(storeService.getStoreProduct(1, 1)).thenReturn(stock);
//
//        //when
//        orderService.newOrder(createOrder);
//
//
//        //then
//        Assertions.assertThat(stock.getStockQuantity()).isEqualTo(stockQuantity - buyQuantity);
//
//    }
//
//    @Test
//    @DisplayName("구매 수량이 재고 수량보다 많을 떄, 정상 주문은 불가능하다.")
//    public void stockQuantityTest_failure() {
//        //given
//        int buyQuantity = 100;
//        int stockQuantity = 50;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1, buyQuantity);
//        CreateOrder createOrder = CreateOrder.builder()
//                .storeId(1)
//                .customerId(1)
//                .quantityByProduct(map)
//                .build();
//        StoreProduct stock = StoreProduct.builder()
//                .stockQuantity(stockQuantity)
//                .build();
//
//        when(storeService.getStoreProduct(1, 1)).thenReturn(stock);
//
//        //when & then
//        assertThrows(RuntimeException.class, () -> {
//            orderService.newOrder(createOrder);
//        });
//
//    }
//
//}