package com.example.hospitalmanagement.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false,foreignKey = @ForeignKey(name = "fk_appointment_patient"))
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false,foreignKey = @ForeignKey(name = "fk_appointment_doctor"))
    private Doctor doctor;

    @Column(name = "appointment_date",nullable = false)
    private LocalDateTime appointmentDate;

    @Column(name = "status")
    private String status = "SCHEDULED";

    @Column(name = "notes")
    private String notes;



}
