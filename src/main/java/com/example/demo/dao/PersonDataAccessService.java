package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//this is utilizing dependency injection to change the implementation in person service.
//the other version of this dependency is in FakePersonDataAccessSerivce under "FakeDao"
@Repository("mysql")
public class PersonDataAccessService implements PersonDao{
    //autowired instantiates this bean and injects our datasource

    private JdbcTemplate jdbcTemplate;


    public PersonDataAccessService(@Autowired JdbcTemplate jdbc)
    {
        jdbcTemplate=jdbc;

    }
    @Override
    public int insertPerson(UUID id, Person person)
    {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String selectpeopleSql = "SELECT id, name FROM people";
      List<Person> personList =   jdbcTemplate.query(selectpeopleSql, new PersonRowMapper());
        return personList;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
    private  static  class PersonRowMapper implements  RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person(UUID.randomUUID(),resultSet.getString("name"));
            return person;
        }
    }
}
