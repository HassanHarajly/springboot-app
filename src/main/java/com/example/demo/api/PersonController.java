package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
    public int addPerson(@RequestBody  @Valid @NonNull Person person)
    {


       return personService.addPerson(person);

    }


    @GetMapping
   public List<Person> getAllPeople()
    {

        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id)
    {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
    personService.deletePerson(id);
    }
    //@valid and @NonNull enforce that a person object must come in with a name attribute, the name object is made required
    //in the model/person with the annotation @NotBlank
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate)
    {
        personService.updatePerson(id,personToUpdate);
    }
}
