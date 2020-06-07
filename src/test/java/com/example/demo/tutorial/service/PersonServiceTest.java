package com.example.demo.tutorial.service;

import com.example.demo.tutorial.dao.FakePersonDataAccessService;
import com.example.demo.tutorial.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    FakePersonDataAccessService fp = new FakePersonDataAccessService();
    PersonService personService= new PersonService(fp);
    UUID personUUID= UUID.randomUUID();
    Person newPerson = new Person(personUUID,"melissa");
    List<Person> person;
    @BeforeEach
    public void init() {
        personService.addPerson(newPerson);
         person = personService.getAllPeople();
    }

    @Test
    void addPerson() {
        assertEquals(person.get(0).getName(),"melissa");

    }

    @Test
    void getAllPeople() {
    }

    @Test
    void getPersonById() {


        Person person2 = personService.getPersonById(personUUID).orElse(null);
        assertEquals(person2.getName(),"melissa");


    }

    @Test
    void deletePerson() {
    }

    @Test
    void updatePerson() {
    }
}
