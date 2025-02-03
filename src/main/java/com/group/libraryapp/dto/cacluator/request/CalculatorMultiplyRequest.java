package com.group.libraryapp.dto.cacluator.request;

public class CalculatorMultiplyRequest {

    private int number1;
    private int number2;

    // @RequestBody로 매개변수 받은 경우 생성자가 없어도 된다.

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }
}
