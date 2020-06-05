package com.example.demo.api;

import com.example.demo.dao.FakePersonDataAccessService;
import com.example.demo.dao.PersonDataAccessService;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonControllerTest {

    @Test
    void addPerson() {
        PersonController personController = new PersonController(new PersonService(new FakePersonDataAccessService()));
        int temp = personController.addPerson(new Person(UUID.randomUUID(),"{{\n" +
                "\t\"name\":\"john jones\"\n" +
                "}}"));
        assertEquals(temp,2);
    }
}
