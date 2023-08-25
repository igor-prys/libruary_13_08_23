package com.example.library.controllers;

import com.example.library.Services.ReservationService;
import com.example.library.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService service;

    @Autowired
    public ReservationController (ReservationService service){
        this.service=service;
    }

    @GetMapping("/{id}")
    public Reservation getOne(@PathVariable (name = "id") Long id  ){
        return service.getOne(id);
    }

    @GetMapping
    public List<Reservation>getAll(){
        return service.getAll();
    }

    @PostMapping
    public Reservation save(@RequestBody Reservation reservation){
        return service.save(reservation);
    }

    @PutMapping
    public Reservation update(@RequestBody Reservation reservation){
       return service.update(reservation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/books/{id}/cont")
    public ResponseEntity<Integer>getCountById(@PathVariable Long id){
        Integer count=service.countById(id);
        if(count==0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(count);
    }

}
