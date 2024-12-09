package com.example.hospitalmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class MedicalRecordDTO {

    private Long id;

    private Long patientId;

    private String diagnosis;

    private String treatment;

    private String testResults;

    private LocalDateTime createdAt;
}
