package com.example.demo.dao;
import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//this tells spring that this class needs to be instantiated as a bean. so that it can be injected into other classes
//this class implements methods from the PersonDao Interface.
@Repository("FakeDao")
public class FakePersonDataAccessService implements  PersonDao {

    private static List<Person> DB= new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }


    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }
}
