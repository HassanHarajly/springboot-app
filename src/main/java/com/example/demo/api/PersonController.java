package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    private static final Logger LOGGER=LoggerFactory.getLogger(Application.class);
    Logger logger = LoggerFactory.getLogger("ol");
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person)
    {

        LOGGER.error(person.getName().toString());
        personService.addPerson(person);
        LOGGER.error("Simple log statement with inputs {}, {} and {}", 1,2,3);
    }
}
