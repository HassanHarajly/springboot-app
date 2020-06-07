package com.example.demo.tutorial.dao;
import com.example.demo.tutorial.model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//this tells spring that this class needs to be instantiated as a bean. so that it can be injected into other classes
//this class implements methods from the PersonDao Interface.
@Repository("FakeDao")
public class FakePersonDataAccessService implements  PersonDao {

    private static List<Person> DB= new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        if (! (person.getId().toString().length()>1))
        {
            DB.add(new Person(id, person.getName()));
        }
        else{
            DB.add(new Person(person.getId(), person.getName()));
        }

        return 2;
    }


    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
      Optional<Person> personMaybe =  selectPersonById(id);
      if (personMaybe.isPresent())
      {
          DB.remove(personMaybe.get());
          return 1;
      }
      else{
          return 0;
      }
    }

    @Override
    public int updatePersonById(UUID id, Person personToUpdate) {
        return selectPersonById(id).map(person->{
            int indexOfPersonToUpdate = DB.indexOf(person);
            if (indexOfPersonToUpdate>=0)
            {
                DB.set(indexOfPersonToUpdate, new Person(id, personToUpdate.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);

    }
}