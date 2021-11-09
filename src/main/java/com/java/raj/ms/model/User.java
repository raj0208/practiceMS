package com.java.raj.ms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer Id;

    private String name;

    @Past
    private Date dob;

    public User() {}

    public User(Integer id, String name, @Past Date dob) {
        Id = id;
        this.name = name;
        this.dob = dob;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
