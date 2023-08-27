package com.example.library.repositories;

import com.example.library.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query("from Person p where p.name=:name111 and p.surname=:surname2222")
    List<Person> findByNameAndSurname(@Param("name111") String name, @Param("surname2222") String surname);
}
