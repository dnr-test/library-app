package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.request.FruitSaveRequest;
import com.group.libraryapp.dto.fruit.request.FruitSellRequest;
import com.group.libraryapp.dto.fruit.response.FruitCountResponse;
import com.group.libraryapp.dto.fruit.response.FruitNotSalesListResponse;
import com.group.libraryapp.dto.fruit.response.FruitSalesStatusResponse;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruits(@RequestBody FruitSaveRequest request) {
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void sellFruits(@RequestBody FruitSellRequest request) {
        fruitService.sellFruits(request.getId());
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitSalesStatusResponse showSalesFruitStatus(@RequestParam String name) {
        return fruitService.showSalesStatus(name);
    }

    @GetMapping("/api/v1/fruit/count")
    public FruitCountResponse countFruitOfStore(@RequestParam String name) {
        return fruitService.countFruitOfStore(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitNotSalesListResponse> showNotSalesFruitListResponse(@RequestParam String option, Long price) {
        return fruitService.showNotSalesFruitListResponse(option, price);
    }
}
