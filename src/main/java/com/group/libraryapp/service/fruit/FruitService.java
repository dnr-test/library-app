package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.fruit.request.FruitSaveRequest;
import com.group.libraryapp.dto.fruit.response.FruitCountResponse;
import com.group.libraryapp.dto.fruit.response.FruitNotSalesListResponse;
import com.group.libraryapp.dto.fruit.response.FruitSalesStatusResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitJdbcRepository) {
        this.fruitRepository = fruitJdbcRepository;
    }

    @Transactional
    public void saveFruit(FruitSaveRequest request) {
        fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }

    @Transactional
    public void sellFruits(Long id) {
        Fruit fruit = fruitRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (isSold(fruit)) {
            throw new IllegalArgumentException("이미 판매됨");
        }

        fruit.sellFruit();
        fruitRepository.save(fruit);
    }

    @Transactional(readOnly = true)
    public FruitSalesStatusResponse showSalesStatus(String name) {
        Long salesAmount = 0L;
        Long notSalesAmount = 0L;

        List<Fruit> fruits = fruitRepository.findAllByName(name);
        for (Fruit fruit : fruits) {
            if (isSold(fruit)) {
                salesAmount += fruit.getPrice();
            } else
                notSalesAmount += fruit.getPrice();
        }

        return new FruitSalesStatusResponse(salesAmount, notSalesAmount);
    }

    @Transactional
    public FruitCountResponse countFruitOfStore(String name) {
        List<Fruit> fruits = fruitRepository.findAllByName(name);

        return new FruitCountResponse(fruits.size());
    }

    @Transactional
    public List<FruitNotSalesListResponse> showNotSalesFruitListResponse(String option, Long price) {
        List<FruitNotSalesListResponse> response = new ArrayList<>();
        List<Fruit> fruits = searchOption(option, price);

        for (Fruit fruit : fruits) {
            if(fruit.isNotSold()) {
            response.add(new FruitNotSalesListResponse(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate()));
            }
        }

        return response;
    }

    private List<Fruit> searchOption(String option, Long price) {
        if (option.equals("GTE")) {
            return fruitRepository.findAllByPriceGreaterThanEqual(price);
        } else if (option.equals("LTE")) {
            return fruitRepository.findAllByPriceLessThanEqual(price);
        } else {
            throw new IllegalArgumentException("조건에 맞는 과일 없음");
        }
    }

    private boolean isSold(Fruit fruit) {
        return fruit.getSold();
    }
}
