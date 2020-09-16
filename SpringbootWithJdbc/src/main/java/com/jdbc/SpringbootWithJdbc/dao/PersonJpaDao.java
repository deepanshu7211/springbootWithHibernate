package com.jdbc.SpringbootWithJdbc.dao;

import com.jdbc.SpringbootWithJdbc.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaDao {

    @PersistenceContext
    EntityManager entityManager;

    public Person findbyId(int id){
        return entityManager.find(Person.class,id);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public void delete(int id){
        Person person = findbyId(id);
        entityManager.remove(person);
    }

    public List<Person> findAllPersons(){
        TypedQuery<Person> find_all_persons = entityManager.createNamedQuery("find_all_persons", Person.class);
        return find_all_persons.getResultList();
    }
}
