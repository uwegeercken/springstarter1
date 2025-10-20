package com.datamelt.springstarter.utility;

import com.datamelt.springstarter.config.ApplicationConfiguration;
import com.datamelt.springstarter.model.Email;
import com.datamelt.springstarter.model.Person;
import com.datamelt.springstarter.port.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner
{
    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

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

            Person person1 = new Person("hansen", "harry", 13, List.of(Email.create("harry.hansen@gmail.de")));
            Person person2 = new Person("hansen", "hubert", 20,List.of(Email.create("hubert.hansen@gmail.de")));
            Person person3 = new Person("friedrichsen", "günther", 33,List.of(Email.create("guenther.friedrichsen@gmail.de")));
            Person person4 = new Person("geercken", "uwe", 6, List.of(Email.create("uwe.geercken@web.de")));

            personRepository.saveAll(Arrays.asList(person1, person2, person3, person4));
        }
    }
}
