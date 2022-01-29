package com.codeclan.DiveLog.DiveLog.models;

import com.codeclan.DiveLog.DiveLog.interfaces.IValveType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "regulators")
public class Regulator implements IValveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "valve_type")
    private ValveType valveType;

    @Column(name = "date_of_last_service")
    private Date dateOfLastService;

    @Column(name = "notes")
    private String notes;

    public Regulator(Long id, String name, ValveType valveType, Date dateOfLastService, String notes) {
        this.id = id;
        this.name = name;
        this.valveType = valveType;
        this.dateOfLastService = dateOfLastService;
        this.notes = notes;
    }

    public Regulator() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ValveType getValveType() {
        return valveType;
    }

    public void setValveType(ValveType valveType) {
        this.valveType = valveType;
    }

    public Date getDateOfLastService() {
        return dateOfLastService;
    }

    public void setDateOfLastService(Date dateOfLastService) {
        this.dateOfLastService = dateOfLastService;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
