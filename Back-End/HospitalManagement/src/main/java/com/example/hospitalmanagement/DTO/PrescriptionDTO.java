package com.example.hospitalmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionDTO {

    private Long id;

    private Long appointmentId;

    private Long doctorId;

    private Long patientId;

    private String medication;

    private String dosage;

    private String instructions;
}
