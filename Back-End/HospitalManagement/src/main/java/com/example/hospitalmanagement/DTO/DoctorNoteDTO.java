package com.example.hospitalmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class DoctorNoteDTO {

    private Long id;

    private Long patientId;

    private Long doctorId;

    private String notes;

    private LocalDateTime createdAt;
}
