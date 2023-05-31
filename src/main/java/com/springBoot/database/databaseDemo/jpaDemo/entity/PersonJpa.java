package com.springBoot.database.databaseDemo.jpaDemo.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
@Entity
@Table(name = "person")
@NamedQuery(name = "find_all", query = "select p  from PersonJpa p")
public class PersonJpa {
    @Id
    @GeneratedValue
    private int id;
//    @Column(name = "name")
    private String name;
    private String location;
    private Date birthDate;

    public PersonJpa() {
    }

    public PersonJpa(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public PersonJpa(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\n"+"id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate;
    }
}
