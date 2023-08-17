package com.example.library.controllers;

import com.example.library.Services.PersonService;
import com.example.library.entities.Person;
import com.example.library.exception.NoSuchPersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable(name = "id") Long id) {
        Person person = personService.findOne(id);
        if (person == null) {
            throw new NoSuchPersonException("Person not found");
        }
        return person;
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable(name = "id") Long id) {
       Person person=personService.findOne(id);
       if(person==null){
           throw new NoSuchPersonException("There is no person with ID= "+id+" in Database");
       }
       personService.deletePerson(id);
    }
}
