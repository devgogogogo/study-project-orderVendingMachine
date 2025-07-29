package com.example.orderkiosk.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Table(name = "stores")
public class Store {

    @Id
    private String storeId;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private ZonedDateTime openAt;

    @Column
    private ZonedDateTime closeAt;


}
