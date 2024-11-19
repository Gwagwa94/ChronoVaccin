package org.example.chronovaccin.entities;

import com.example.vaccination.model.Centre;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="consultations")
public class Consultation {

    @Id
    @Column(name="id")
    private Integer id;
    @OneToOne
    @JoinColumn(name="medecin_id", foreignKey = @ForeignKey(name="consultations_medecin_id_fkey"))
    private Doctor doctor;
    @OneToOne
    @JoinColumn(name="patient_id", foreignKey = @ForeignKey(name="consultations_patient_id_fkey"))
    private Patient patient;
    @OneToOne
    @JoinColumn(name="centre_id", foreignKey = @ForeignKey(name="consultations_centre_id_fkey"))
    private Centre centre;
    @Column(name="date")
    private Date date;
    @Column(name="heure")
    private String heure;
    @Column(name="statut")
    private String status;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setCentre(Centre centre) {
        this.centre = centre;
    }
    public Centre getCentre() {
        return centre;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public void setHeure(String heure) {
        this.heure = heure;
    }
    public String getHeure() {
        return heure;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
