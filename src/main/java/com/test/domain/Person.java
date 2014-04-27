package com.test.domain;

import com.test.domain.util.GENDER;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {

    @Id
    @Column(name="person_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @Column(insertable=false, updatable=false, unique=true)
//    @Formula("concat(firstName, ' ', lastName)")
    @Formula("concat(' ', ' ')")
    private String name;

    @Column(length = 1)
    private GENDER gender;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
