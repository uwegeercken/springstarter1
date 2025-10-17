package com.datamelt.springstarter;

public class Person
{
    private final int id;
    private final String lastname;
    private final String firstname;
    private final int age;

    public Person(int id, String lastname, String firstname, int age)
    {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
    }

    public int getId()
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
}
