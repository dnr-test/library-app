package com.group.libraryapp.dto.fruit.response;

public class FruitSalesStatusResponse {
    private final Long salesAmount;
    private final Long notSalesAmount;

    public FruitSalesStatusResponse(Long salesAmount, Long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
