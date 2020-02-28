package com.optional.OptionalDemo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

    Long userId;
    String firstName;
    String lastName;
    List<Phone> phones = new ArrayList<>();

    /*public User() {
        super();
    }*/

    public User(Long userId, String firstName, String lastName, List<Phone> phones) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = phones;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phones=" + phones +
                '}';
    }
}
