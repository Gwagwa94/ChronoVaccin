package org.example.chronovaccin.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="patients")
public class Patient {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="prenom")
    private String firstname;
    @Column(name="nom")
    private String lastname;
    @Column(name="date_de_naissance")
    private Date birthDate;
    @OneToOne
    @JoinColumn(name="adresse_id", foreignKey = @ForeignKey(name = "patients_adresse_id_fkey"))
    private Address address;
    @OneToOne
    @JoinColumn(name="medecin_id", foreignKey = @ForeignKey(name = "patients_medecin_id_fkey"))
    private Doctor doctor;

//    public Patient(Integer id, String firstname, String name, Date birthDate) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.birthDate = birthDate;
//    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    
}
