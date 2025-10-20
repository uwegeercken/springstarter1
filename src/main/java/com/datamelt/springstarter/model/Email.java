package com.datamelt.springstarter.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Email
{
    private String address;

    private Email() {
    }

    private Email(String address)
    {
        if (!isValidEmail(address)) {
            throw new IllegalArgumentException("Invalid email address format.");
        }
        this.address = address;
    }

    public static Email create(String address) {
        return new Email(address);
    }

    public String getAddress()
    {
        return address;
    }

    private static boolean isValidEmail(String emailAddress) {
        return emailAddress != null && emailAddress.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }
}
