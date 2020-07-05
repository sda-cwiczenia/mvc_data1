package com.sda.mvc_data1;

import com.sda.mvc_data1.model.Person;
import com.sda.mvc_data1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RunOnStartup {

    PersonRepository repository;

    public RunOnStartup(PersonRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void runOnStartup() {
        Person person1 = new Person("Jan", "Kowalski", 45);
        Person person2 = new Person("Ewa", "Majtyka", 35);
        Person person3 = new Person("Robert", "Piotrowski", 22);
        Person person4 = new Person("Robert", "Kalinowski", 25);

        repository.save(person1);
        repository.save(person2);
        repository.save(person3);
        repository.save(person4);

    }
}
