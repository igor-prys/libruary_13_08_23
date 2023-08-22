package com.example.library.Services;

import com.example.library.entities.Person;
import com.example.library.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService  {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    public Person findOne(Long id){
        return  personRepository.findById(id).orElse(null);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public Person updatePerson(Person person){
        return personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
