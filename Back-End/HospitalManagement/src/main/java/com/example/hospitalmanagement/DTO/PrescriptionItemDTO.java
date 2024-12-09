package com.example.hospitalmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionItemDTO {

    private Long id;

    private Long prescriptionId;

    private String medication;

    private String dosage;

    private Integer quantity;
}
