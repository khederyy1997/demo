package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {



    int updatePersonById(UUID id ,Person person);
    int deletePersonById(UUID id );
    Optional<Person> selectPersonById(UUID id);
    int insertperson(UUID id , Person person);
    default  int insertperson(Person person){
        UUID id =UUID.randomUUID();
        return insertperson(id,person);
    }
List<Person> selectallpersons();
}
