package com.datamelt.springstarter;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String lastname;
    private  String firstname;
    private  int age;

    public Person()
    {
    }

    public Person(String lastname, String firstname, int age)
    {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
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
}
