package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fake")
public class FakeDataAccess implements PersonDao {
    @Override
    public int updatePersonById(UUID id, Person person) {
      return  selectPersonById(id).map(p -> {
          int indexOfDeletePerson=DB.indexOf(p);
          if(indexOfDeletePerson>=0){
              DB.set(indexOfDeletePerson,new Person(id,person.getName()));
              return 1;
          } return 0;

      }).orElse(0);
    }

         @Override
        public int deletePersonById(UUID id) {
            Optional<Person> personMaybe =selectPersonById(id);
            if(personMaybe.isPresent()){
                DB.remove(personMaybe.get());
                return 1;

            }else

                return 0;

    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    private  static  List<Person> DB = new ArrayList<>();
    @Override
    public int insertperson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return  1;
    }

    @Override
    public List<Person> selectallpersons() {
        return DB;
    }


}
