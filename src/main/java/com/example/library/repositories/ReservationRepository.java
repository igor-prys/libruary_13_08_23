package com.example.library.repositories;

import com.example.library.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("select count(r) from Reservation r where r.book.id=:book_id")
    int countById(@Param("book_id")Long bookId);
}
