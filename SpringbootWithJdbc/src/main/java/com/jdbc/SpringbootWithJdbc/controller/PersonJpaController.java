package com.jdbc.SpringbootWithJdbc.controller;

import com.jdbc.SpringbootWithJdbc.dao.PersonJpaDao;
import com.jdbc.SpringbootWithJdbc.exception.UserNotFoundException;
import com.jdbc.SpringbootWithJdbc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonJpaController {

    @Autowired
    private PersonJpaDao personJpaDao;

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable int id){
        Person person = personJpaDao.findbyId(id);
        if(person==null){
            throw new UserNotFoundException(" User not found " + id);
        }
        return person;
    }

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personJpaDao.findAllPersons();
    }

    @PostMapping("/persons")
    public ResponseEntity savePerson(@RequestBody Person person){
        Person person1 = personJpaDao.insert(person);
        return new ResponseEntity(person1, HttpStatus.CREATED);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity deletePerson(@PathVariable int id){
        personJpaDao.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

