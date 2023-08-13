package com.example.library.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "language")
    private String language;

    @Column(name="country")
    private String country;

    private int countOfBooks;

    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;



}
