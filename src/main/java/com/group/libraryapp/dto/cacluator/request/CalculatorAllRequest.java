package com.group.libraryapp.dto.cacluator.request;

public class CalculatorAllRequest {
    private int num1;
    private int num2;

    public CalculatorAllRequest(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
