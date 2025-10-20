package com.datamelt.springstarter.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotBlank(message = "lastname is required")
    private  String lastname;
    @NotBlank(message = "firstname is required")
    private  String firstname;
    @Min(value = 0, message = "age must be at least 0")
    @Max(value = 120, message = "age must be less than or equal to 120")
    private  int age;

    @ElementCollection
    private List<Email> emails;

    public Person()
    {
    }

    public Person(String lastname, String firstname, int age, List<Email> emails)
    {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.emails = emails;
    }

    public Long getId()
    {
        return id;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public int getAge()
    {
        return age;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public List<Email> getEmails()
    {
        return emails;
    }

    public void setEmails(List<Email> emails)
    {
        this.emails = emails;
    }
}
