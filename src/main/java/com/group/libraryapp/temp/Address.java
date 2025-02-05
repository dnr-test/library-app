package com.group.libraryapp.temp;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String street;

    @OneToOne(mappedBy = "address")
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }
}
