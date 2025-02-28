package org.example.chronovaccin.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class User {
    @Id
    @Column(name ="email" ,unique = true, nullable = false)
    private String email;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Column(name = "is_user")
    private boolean isUser;

    @Column(name = "is_doctor")
    private boolean isDoctor;


    public User(){}

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}