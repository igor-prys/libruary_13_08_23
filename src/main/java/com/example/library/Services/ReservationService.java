package com.example.library.Services;

import com.example.library.entities.Book;
import com.example.library.entities.Reservation;
import com.example.library.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ReservationService {
    private final static int ALLOWED_DAYS = 3;
    private ReservationRepository repository;

    @Autowired
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public Reservation getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Reservation> getAll() {
        return repository.findAll();
    }

    public Reservation save(Reservation reservation) {
        ZoneId currentZone = ZoneId.systemDefault();
        Long registrationDate=LocalDateTime.now().atZone(currentZone).toInstant().toEpochMilli();
        reservation.setRegistrationDate(registrationDate);
        return repository.save(reservation);
    }

    public Reservation update(Reservation reservation) {
        return repository.save(reservation);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public int countById(Long id) {
        return repository.countById(id);
    }


    public List<Reservation> findOldReservations() {
        ZoneId currentZone = ZoneId.systemDefault();
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime expirationDate = currentDate.minusDays(ALLOWED_DAYS);
        Long expirationDateInMilliseconds = expirationDate.atZone(currentZone).toInstant().toEpochMilli();
        return repository.findOldReservations(expirationDateInMilliseconds);
    }
}
