package com.datamelt.springstarter.adapter;

import com.datamelt.springstarter.Person;
import com.datamelt.springstarter.port.PersonLoader;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class PersonMemoryRepository implements PersonLoader
{
    private final Map<Integer, Person> persons = new HashMap<>();

    public PersonMemoryRepository()
    {
        loadAllPersons();
    }

    @Override
    public void loadAllPersons()
    {
        persons.put(1, new Person(1,"Geercken","Uwe",61));
        persons.put(2, new Person(2,"Husten","Heinz",37));
    }

    @Override
    public Optional<Person> getPersonById(int id)
    {
        return Optional.ofNullable(persons.get(id));
    }

    @Override
    public Optional<Person> getPersonByLastname(String lastname)
    {
        return persons.values().stream()
                .filter(person -> person.getLastname().equals(lastname))
                .findAny();
    }
}
