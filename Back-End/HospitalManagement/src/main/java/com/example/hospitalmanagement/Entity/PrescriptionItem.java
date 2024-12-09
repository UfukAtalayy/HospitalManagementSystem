package com.example.hospitalmanagement.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prescriptionitem")
public class PrescriptionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prescription_id",nullable = false)
    private Prescription prescription;

    @Column(name = "medication",nullable = false)
    private String medication;

    @Column(name = "dosage",nullable = false)
    private String dosage;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;
}
