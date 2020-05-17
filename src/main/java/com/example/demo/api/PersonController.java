package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;


    //no qualifier is needed here for the service since it will be treated as a singleton and as a result has no interface.
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //postmapping tells the rest controller what function to call when a post request is made
    //RequestBody tells spring where to put the post body data into
    @PostMapping
    public void addPerson(@RequestBody Person person)
    {

        personService.addPerson(person);
    }

    @GetMapping
   public List<Person> getAllPeople()
    {
        return personService.getAllPeople();
    }
}
