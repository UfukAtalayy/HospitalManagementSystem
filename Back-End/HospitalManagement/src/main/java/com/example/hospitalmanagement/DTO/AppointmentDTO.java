package com.example.hospitalmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDTO {

    //Getters and Setters
    private Long id;

    private Long patientId;

    private Long doctorId;

    private LocalDateTime appointmentDate;

    private String status;

    private String notes;

}
