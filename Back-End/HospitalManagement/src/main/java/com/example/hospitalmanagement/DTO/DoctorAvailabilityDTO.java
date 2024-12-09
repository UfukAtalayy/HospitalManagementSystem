package com.example.hospitalmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class DoctorAvailabilityDTO {

    private Long id;

    private Long doctorId;

    private LocalDateTime availableFrom;

    private LocalDateTime availableTo;
}
