package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PersonService {

    private final PersonDao personDao;

    //this is doing dependency injection, essentially the personDao is a singleton marked by fakedao that we can inject into any of our services
    //@qualifier distinguishes between the actual class that is inheriting the implementation of PersonDao.
    //so the qualifier goes to the implementations of persondao and finds the one that matches fakedao.
    //this qualifier allows us to have multiple classes implementing the personDao interface and inject them as we need.
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
        System.out.println(personDao);
    }

    public int addPerson(Person person)
    {
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople()
    {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id )
    {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id)
    {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson)
    {
        return personDao.updatePersonById(id,newPerson);
    }

}
