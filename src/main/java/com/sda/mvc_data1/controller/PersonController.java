package com.sda.mvc_data1.controller;

import com.sda.mvc_data1.model.Person;
import com.sda.mvc_data1.model.PersonDTO;
import com.sda.mvc_data1.repository.PersonRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/sda")
public class PersonController {

    PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }
@GetMapping("/person-add")
    public String pobierzFormularz(Model model) {
        PersonDTO form = new PersonDTO();
        model.addAttribute("form", form);
        return "person-add";
    }

    @PostMapping("/person-add")
    public String dodajOsobe(@ModelAttribute("form") @Valid PersonDTO form, BindingResult result) {
        if (result.hasErrors()) {
            return "/person-add";
        } else {
            Person person = new Person();
            person.setImie(form.getImie());
            person.setNazwisko(form.getNazwisko());
            person.setWiek(form.getWiek());
            repository.save(person);
            return "redirect://sda/person-added";
        }

    }

//    //@RequestMapping(value = "/persons", method = {RequestMethod.GET, RequestMethod.DELETE})
//    @GetMapping("/persons")
//    @ResponseBody   // to jest potrzebne kiedy typ kontrolera jest @Controller a nie @RestController
//    public List<Person> getAllPersons(@RequestParam(required = false, defaultValue = "") String imie,
//                                      @RequestParam(required = false, defaultValue = "") String nazwisko) {
//
//        if (!imie.equals("") && !nazwisko.equals("")) {
//            return repository.findByImieAndNazwisko(imie, nazwisko);
//        }
//
//        if (!imie.equals("") && nazwisko.equals("")) {
//            return repository.findByImie(imie);
//        }
//
//        if (imie.equals("") && !nazwisko.equals("")) {
//            return repository.findByNazwisko(nazwisko);
//        }
//
//        if (imie.equals("") && nazwisko.equals("")) {
//            return repository.findAll();
//        }
//
//        return repository.findAll();
//
//    }
//
//    @PostMapping("/persons")
//    public Person addPerson(@RequestBody Person person) {
//        repository.save(person);
//        return person;
//    }
//
//    @GetMapping("/test")
//    public ResponseEntity<String> testFind(@RequestParam String imie) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Custom-Header1", "tesetParametr1");
//        headers.add("Custom-Header2", "tesetParametr2");
//        if (imie.equals("Ewa")) {
//            return  new ResponseEntity("Znalazłem Ewę", headers, HttpStatus.OK);
//        } else return new ResponseEntity<>("Ewa już tutaj nie mieszka", headers, HttpStatus.NOT_FOUND);
//
//    }


}
