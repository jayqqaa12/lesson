package com.jayqqaa12.model;

import java.time.LocalDate;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    public String name;
    public LocalDate birthday;
    public Sex gender;
    public String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public Sex getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

}