package com.example.orderkiosk.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(name = "stores")
public class Store {

    @Id
    private int storeId;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String openAt;

    @Column
    private String closeAt;


}
