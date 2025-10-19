package com.datamelt.springstarter;

import com.datamelt.springstarter.config.ApplicationConfiguration;
import com.datamelt.springstarter.port.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController
{
    private final ApplicationConfiguration configuration;
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(ApplicationConfiguration configuration, PersonRepository personRepository)
    {
        this.configuration = configuration;
        this.personRepository = personRepository;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getPersonById(@PathVariable long id)
    {
        Optional<Person> person = personRepository.findById(id);
        return person
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok(Collections.emptyMap()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons()
    {
        return ResponseEntity.ok(personRepository.findAll());
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person)
    {
        personRepository.save(person);
    }

    // Endpoint for deleting a person by ID
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable long id) {
        personRepository.delete(personRepository.getReferenceById(id));
        return ResponseEntity.ok(Collections.singletonMap("message", "Person deleted"));
    }

    // Endpoint for deleting all persons
    @DeleteMapping("/all")
    public ResponseEntity<Object> deleteAllPersons() {
        personRepository.deleteAll();
        return ResponseEntity.ok(Collections.singletonMap("message", "All persons deleted"));
    }

//    @GetMapping("/lastname/{lastname}")
//    public ResponseEntity<Object> getPersonByLastname(@PathVariable String lastname)
//    {
//        Optional<Person> person = personLoader.getPersonByLastname(lastname);
//        return person
//                .<ResponseEntity<Object>>map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.ok(Collections.emptyMap()));
//    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex)
    {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("error", "invalid value: " + ex.getValue() + ". id must be a valid integer."));
    }
}
