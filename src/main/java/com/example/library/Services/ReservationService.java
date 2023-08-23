package com.example.library.Services;

import com.example.library.entities.Book;
import com.example.library.entities.Reservation;
import com.example.library.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository repository;

    public ReservationService(@Autowired ReservationRepository repository){
        this.repository=repository;
    }

    public Reservation getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Reservation>getAll(){
        return repository.findAll();
    }
    public Reservation save(Reservation reservation){
        return repository.save(reservation);
    }

    public Reservation update(Reservation reservation){
        return repository.save(reservation);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
