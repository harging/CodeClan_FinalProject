package com.codeclan.DiveLog.DiveLog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "sample_points")
public class SamplePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dive_id", nullable = false)
    private Dive dive;

    @Column(name="depth")
    private double depth;

    public SamplePoint(double depth, Dive dive) {
        this.depth = depth;
        this.dive = dive;
    }

    public SamplePoint() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dive getDive() {
        return dive;
    }

    public void setDive(Dive dive) {
        this.dive = dive;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}