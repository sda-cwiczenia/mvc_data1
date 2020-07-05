package com.sda.mvc_data1.repository;

import com.sda.mvc_data1.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findByImieAndNazwisko(String imie, String nazwisko);

    List<Person> findByImie(String imie);

    List<Person> findByNazwisko(String nazwisko);
}
