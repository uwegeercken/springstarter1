package com.datamelt.springstarter;

import com.datamelt.springstarter.config.ApplicationConfiguration;
import com.datamelt.springstarter.port.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner
{
    private final PersonRepository personRepository;
    private final ApplicationConfiguration config;

    public DataLoader(PersonRepository personRepository, ApplicationConfiguration config) {
        this.personRepository = personRepository;
        this.config = config;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception
    {
        if(config.isLoadDataOnStartup())
        {
            personRepository.deleteAll();

            Person person1 = new Person("hansen", "harry", 13);
            Person person2 = new Person("hansen", "hubert", 20);
            Person person3 = new Person("friedrichsen", "günther", 33);
            Person person4 = new Person("geercken", "uwe", 6);

            personRepository.saveAll(Arrays.asList(person1, person2, person3, person4));
        }
    }
}
