package org.example.chronovaccin.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="patients")
public class Specialty {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="nom")
    private String name;

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

    
}
