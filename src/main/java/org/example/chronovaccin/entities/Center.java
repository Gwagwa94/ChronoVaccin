package org.example.chronovaccin.entities;

import jakarta.persistence.*;

@Entity
@Table(name="centres")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="nom")
    private String name;
    @OneToOne
    @JoinColumn(name="adresse_id", foreignKey = @ForeignKey(name="centres_adresse_id_fkey"))
    private Address address;
    @Column(name="telephone")
    private String phone;

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
        return this.address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
