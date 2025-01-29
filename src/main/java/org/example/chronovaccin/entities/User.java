package org.example.chronovaccin.entities;

import jakarta.persistence.*;

@Entity
@Table(name="utilisateurs")
public class User {
    @Id
    @Column(name="email")
    private String email;

    @Column(name="is_user")
    private Boolean is_user;

    @Column(name="is_admin")
    private Boolean is_admin;

    public boolean getIs_user() {
        return is_user;
    }

    public boolean getIs_admin() {
        return is_admin;
    }
}
