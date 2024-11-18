package org.example.chronovaccin.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name="address_docteur_fk"))
    private Address address;


    @ManyToMany
    private List<Patient> patientele;

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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    

}
