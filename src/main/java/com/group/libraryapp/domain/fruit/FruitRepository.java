package com.group.libraryapp.domain.fruit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    List<Fruit> findAllByName(String name);

    List<Fruit> findAllByPriceGreaterThanEqual(Long price);

    List<Fruit> findAllByPriceLessThanEqual(Long price);
}
