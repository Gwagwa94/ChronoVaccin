package org.example.chronovaccin.service;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="patients")
public class Patient {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="birth_date")
    private Date birthDate;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "address_id"))
    private Address address;


    @ManyToOne
    private Doctor preferedDoctor;

    public Patient(){}

    public Patient(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    
}
