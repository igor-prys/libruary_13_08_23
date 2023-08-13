package com.example.library.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "reservation")
    private List<Book> bookList;

    @OneToMany(mappedBy = "reservation")
    private List<Person> personList;

}
