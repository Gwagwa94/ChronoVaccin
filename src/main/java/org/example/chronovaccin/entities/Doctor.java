package org.example.chronovaccin.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "medecins")
public class Doctor {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="prenom")
    private String firstname;
    @Column(name="nom")
    private String lastname;
    @OneToOne
    @JoinColumn(name="centre_id", foreignKey = @ForeignKey(name="medecins_centre_id_fkey"))
    private Center centre;
    @OneToOne
    @JoinColumn(name = "adresse_id", foreignKey = @ForeignKey(name="medecins_adresse_id_fkey"))
    private Address address;
    @OneToOne
    @JoinColumn(name="specialite_id", foreignKey = @ForeignKey(name="medecins_specialite_id_fkey"))
    private Specialty specialty;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    

}
