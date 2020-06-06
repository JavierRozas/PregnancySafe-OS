package com.acme.pregnancysafe.resource;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TP_MEDICALAPPOINTMENT")
public class MedicalAppointmentResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long idObstetrician;
    
    private Long idMother;
    
    private Date date;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdObstetrician() {
        return idObstetrician;
    }

    public void setIdObstetrician(Long idObstetrician) {
        this.idObstetrician = idObstetrician;
    }

    public Long getIdMother() {
        return idMother;
    }

    public void setIdMother(Long idMother) {
        this.idMother = idMother;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
