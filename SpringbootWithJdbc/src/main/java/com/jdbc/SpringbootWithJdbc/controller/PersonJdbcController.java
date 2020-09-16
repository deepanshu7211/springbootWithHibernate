package com.jdbc.SpringbootWithJdbc.controller;

import com.jdbc.SpringbootWithJdbc.dao.PersonJdbcDao;
import com.jdbc.SpringbootWithJdbc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonJdbcController {

    @Autowired
    private PersonJdbcDao personJdbcDao;

    @GetMapping("/jdbcperson")
    public List<Person> getPersons(){
        return personJdbcDao.findAll();
    }
}
