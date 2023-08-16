package com.example.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @Column(name="countofbooks")
    private int countOfBooks;

//    @OneToMany(mappedBy = "book")
//    private List<Reservation>reservations;



}
