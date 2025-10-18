package com.datamelt.springstarter.port;

import com.datamelt.springstarter.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonLoader extends JpaRepository<Person, Long>
{

}
