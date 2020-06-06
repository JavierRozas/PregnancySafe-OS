package com.acme.pregnancysafe.resource;


import javax.persistence.*;

@Entity
@Table(name = "TP_MEDICALEXAM")
public class MedicalExamResource {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long idObstetrician;

    private Long idMother;
    
    private String examType;
    
    private String Description;
    
    private String Result;
    
    private String datePrescription;

    
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

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getDatePrescription() {
        return datePrescription;
    }

    public void setDatePrescription(String datePrescription) {
        this.datePrescription = datePrescription;
    }
}
