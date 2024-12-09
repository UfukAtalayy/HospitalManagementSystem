package com.example.hospitalmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class LabStaffDTO {

    private Long id;

    private String name;

    private String role;

    private String phone;

    private LocalDateTime createdAt;
}
