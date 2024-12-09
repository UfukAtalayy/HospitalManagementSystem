package com.example.hospitalmanagement.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "doctornotes")
public class DoctorNote {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false,foreignKey = @ForeignKey(name = "fk_patient_doctornote"))
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false,foreignKey = @ForeignKey(name = "fk_doctor_doctornote"))
    private Doctor doctor;
    @Column(name = "notes")
    private String notes;
    @Column(name = "created_at")
    private LocalDateTime createdAt=LocalDateTime.now();
}
