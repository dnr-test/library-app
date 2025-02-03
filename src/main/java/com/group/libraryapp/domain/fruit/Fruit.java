package com.group.libraryapp.domain.fruit;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    private LocalDate warehousingDate;

    @Column(nullable = false)
    private Long price;

    private Boolean sold = false;

    public Fruit() {
    }

    public Fruit(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }

    public Boolean getSold() {
        return sold;
    }

    public void sellFruit() {
        this.sold = true;
    }

    public boolean isNotSold() {
        return !this.sold;
    }
}
