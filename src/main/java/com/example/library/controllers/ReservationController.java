package com.example.library.controllers;

import com.example.library.Services.BookService;
import com.example.library.Services.ReservationService;
import com.example.library.dto.ReservationDto;
import com.example.library.entities.Book;
import com.example.library.entities.Person;
import com.example.library.entities.Reservation;
import com.example.library.exception.NoSuchBookException;
import com.example.library.exception.OutOfBooKException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;
    private BookService bookService;

    @Autowired
    public ReservationController(ReservationService service, BookService bookService) {
        this.reservationService = service;
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ReservationDto getOne(@PathVariable(name = "id") Long id) {
        Reservation reservation=reservationService.getOne(id);
        Book book=reservation.getBook();
        Person person=reservation.getPerson();
        ReservationDto reservationDto=new ReservationDto();
        reservationDto.setBookAuthor(book.getAuthor());
        reservationDto.setBookName(book.getAuthor());
        reservationDto.setPersonFullName(person.getName()+" "+person.getSurname());
        reservationDto.setDescription(reservation.getDescription());
        reservationDto.setRegistrationDate(reservationDto.getRegistrationDate());
        return reservationDto;
    }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @PostMapping
    public Reservation save(@RequestBody Reservation reservation) {
       Book book=bookService.findOne(reservation.getBook().getId());
       if(book==null){
           throw new NoSuchBookException("Book is not exist");
       }
        int countOfBook = book.getCountOfBooks();
        int countOfBookInReservation = reservationService.countById(reservation.getBook().getId());
        if (countOfBookInReservation == countOfBook) {
            throw new OutOfBooKException("All books are reserved");
        }
        return reservationService.save(reservation);
    }

    @PutMapping
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservationService.delete(id);
    }

    @GetMapping("/books/{id}/count")
    public ResponseEntity<Map<String, Integer>> getCountById(@PathVariable Long id) {
        Integer count = reservationService.countById(id);
        if (count == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(Collections.singletonMap("count", count));
    }

    @GetMapping("/expired")
    public List<Reservation>findOldReservations(){
        return reservationService.findOldReservations();
    }
}
