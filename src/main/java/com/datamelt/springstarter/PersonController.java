package com.datamelt.springstarter;

import com.datamelt.springstarter.config.ApplicationConfiguration;
import com.datamelt.springstarter.port.PersonLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController
{
    private final ApplicationConfiguration configuration;
    private final PersonLoader personLoader;

    @Autowired
    public PersonController(ApplicationConfiguration configuration, PersonLoader personLoader)
    {
        this.configuration = configuration;
        this.personLoader = personLoader;
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getPersonById(@PathVariable int id)
    {
        Optional<Person> person = personLoader.getPersonById(id);
        return person
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok(Collections.emptyMap()));
    }

    @GetMapping("/lastname/{lastname}")
    public ResponseEntity<Object> getPersonByLastname(@PathVariable String lastname)
    {
        Optional<Person> person = personLoader.getPersonByLastname(lastname);
        return person
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok(Collections.emptyMap()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex)
    {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("error", "invalid value: " + ex.getValue() + ". id must be a valid integer."));
    }
}
