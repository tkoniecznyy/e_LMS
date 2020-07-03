package com.tkonieczny.elms.classes;

public class UserInfo {
    String name;
    String surname;
    String email;

    public UserInfo(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
