package com.example.hospitalmanagement.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "doctoravailability")
public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false,foreignKey = @ForeignKey(name = "fk_doctor_doctoravailability"))
    private Doctor doctor;
    @Column(name ="available_from",nullable = false )
    private LocalDateTime availableFrom;
    @Column(name = "available_to",nullable = false)
    private LocalDateTime availableTo;
}
