package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;
@Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }
    public  int addPerson(@Qualifier("fake")  Person person  ){
        return  personDao.insertperson(person);
    }
    public  int deletePersonById( UUID id  ){
        return  personDao.deletePersonById(id);
    }
    public  int updatePersonById( UUID id ,Person person ){
        return  personDao.updatePersonById(id,person);
    }
    public List<Person> getallperson(){
    return  personDao.selectallpersons();
    }
    public Optional<Person> getPersonById(UUID id){
        return  personDao.selectPersonById(id);
    }
}
