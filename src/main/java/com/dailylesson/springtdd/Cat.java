package com.dailylesson.springtdd;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name= "cat")
public class Cat {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    public Cat(String name) {
        Assert.isTrue(Character.isUpperCase(name.charAt(0)), ()-> "the first character of the name must be UpperCase");
        this.name = name;
    }

    private Cat() {

    }
    public Cat(String name, LocalDate dateOfBirth) {
        this(name);
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }
    public Integer getAgeInMoths() {
        if(this.dateOfBirth == null){
            return null;
        }
        return Period.between(dateOfBirth,LocalDate.now()).getMonths();
    }
}
