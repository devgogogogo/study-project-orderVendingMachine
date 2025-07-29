package com.example.orderkiosk.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.relational.core.sql.In;

import java.util.Map;

@Getter
@Builder
public class CreatOrder {
    private int customerId;
    private Map<Integer, Integer> quantityByProduct;
}
