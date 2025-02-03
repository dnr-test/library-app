package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.domain.calculator.Calculator;
import com.group.libraryapp.dto.cacluator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.cacluator.request.CalculatorAllRequest;
import com.group.libraryapp.dto.cacluator.request.CalculatorMultiplyRequest;
import com.group.libraryapp.dto.cacluator.request.CalculatorSumArrayRequest;
import com.group.libraryapp.dto.cacluator.response.CalculatorDayOfWeek;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class CalculatorController {

    @GetMapping("/add") // Get /add
    public int addTwoNumber(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply") // Post /multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }

    //과제2일차-1
    @GetMapping("/api/v1/calc")
    public Calculator calcTwoNumber(CalculatorAllRequest request) {
        int add = request.getNum1() + request.getNum2();
        int minus = request.getNum1() - request.getNum2();
        int multiply = request.getNum1() * request.getNum2();

        return new Calculator(add, minus, multiply);
    }

    //과제2일차-2
    @GetMapping("/api/v1/day-of-week")
    public CalculatorDayOfWeek calcDayOfWeek(@RequestParam String date) {
        LocalDate ld = LocalDate.parse(date);
        return new CalculatorDayOfWeek(ld.getDayOfWeek());
    }

    //과제2일차-3
    @PostMapping("/api/v1/sumArray")
    public int calcSumArray(@RequestBody CalculatorSumArrayRequest request) {
        int[] numbers = request.getNumbers();

        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        
        return sum;
    }
}
