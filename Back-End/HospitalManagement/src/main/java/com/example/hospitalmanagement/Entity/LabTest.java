package com.example.hospitalmanagement.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "labtests")
public class LabTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false)
    private Doctor doctor;

    @Column(name = "test_name",nullable = false)
    private String testName;

    @Column(name = "test_date",nullable = false)
    private LocalDateTime testDate;

    @Column(name = "results")
    private String results;

    @ManyToOne
    @JoinColumn(name = "status_id",nullable = false)
    private TestStatus testStatus;

    @ManyToOne
    @JoinColumn(name = "lab_staff_id",nullable = false)
    private LabStaff labStaff;

}
