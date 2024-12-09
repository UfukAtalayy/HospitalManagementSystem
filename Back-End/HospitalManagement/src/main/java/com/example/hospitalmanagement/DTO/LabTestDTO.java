package com.example.hospitalmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LabTestDTO {

    private Long id;

    private Long patientId;

    private Long doctorId;

    private String testName;

    private LocalDateTime testDate;

    private String results;

    private Long statusId;

    private Long labStaffId;

}
