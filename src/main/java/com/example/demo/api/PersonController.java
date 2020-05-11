package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person)
    {
        personService.addPerson(person);
    }
    @GetMapping("/getMapping")
    public int returnNum()
    {
       return 1;
    }
}
