package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;

    //this jsonproperty annotation tells spring that the post json
    // request with for example attribute "name" will map to the java object name
    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;

        this.name = name;
    }

    public UUID getId() {
        return id;
    }



    public String getName() {
        return name;
    }




}
