package com.datamelt.springstarter.port;

import com.datamelt.springstarter.Person;

import java.util.Optional;

public interface PersonLoader
{
    void loadAllPersons();
    Optional<Person> getPersonById(int id);
    Optional<Person> getPersonByLastname(String lastname);
}
