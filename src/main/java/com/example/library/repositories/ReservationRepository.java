package com.example.library.repositories;

import com.example.library.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("select count(r) from Reservation r where r.book.id=:book_id")
    int countById(@Param("book_id")Long bookId);

//    @Query("from Reservation r  join fetch  r.book join fetch  r.person")
//    List<Reservation> getAll();

    @Query("from Reservation r where r.registrationDate<:comparingDate")
    List<Reservation>findOldReservations(@Param("comparingDate") Long comparingDate);
}
