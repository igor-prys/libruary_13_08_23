package com.example.library.Services;

import com.example.library.entities.Person;
import com.example.library.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private PersonRepository personRepository;

    public AuthorService(@Autowired PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    public List<Person>getAll(){
        return personRepository.findAll();
    }

    public Person getPerson(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public Person savePerson(Person  person){
        return personRepository.save(person);
    }

    public Person updatePerson(Person person){
        return personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
