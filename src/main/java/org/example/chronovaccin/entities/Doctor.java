package org.example.chronovaccin.entities;

import jakarta.persistence.*;

@Entity
@Table(name="medecins")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="prenom")
    private String firstname;
    @Column(name="nom")
    private String lastname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="centre_id", foreignKey = @ForeignKey(name="medecins_centre_id_fkey"), referencedColumnName = "id")
    private Center centre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id", foreignKey = @ForeignKey(name="medecins_adresse_id_fkey"), referencedColumnName = "id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="specialite_id", foreignKey = @ForeignKey(name="medecins_specialite_id_fkey"), referencedColumnName = "id")
    private Specialty specialty;

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
    public Center getCentre() {
        return centre;
    }
    public void setCentre(Center centre) {
        this.centre = centre;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Specialty getSpecialty() {
        return specialty;
    }
    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
