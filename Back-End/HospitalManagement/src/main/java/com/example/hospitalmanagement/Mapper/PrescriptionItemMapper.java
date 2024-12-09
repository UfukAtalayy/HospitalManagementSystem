package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.PrescriptionItemDTO;
import com.example.hospitalmanagement.Entity.Prescription;
import com.example.hospitalmanagement.Entity.PrescriptionItem;
import org.springframework.stereotype.Component;

@Component
public class PrescriptionItemMapper {

    public PrescriptionItemDTO toDTO(PrescriptionItem prescriptionItem){
        PrescriptionItemDTO dto = new PrescriptionItemDTO();
        dto.setId(prescriptionItem.getId());
        dto.setPrescriptionId(prescriptionItem.getPrescription().getId());
        dto.setMedication(prescriptionItem.getMedication());
        dto.setDosage(prescriptionItem.getDosage());
        dto.setQuantity(prescriptionItem.getQuantity());
        return dto;
    }

    public PrescriptionItem toEntity(PrescriptionItemDTO prescriptionItemDTO, Prescription prescription){
        PrescriptionItem prescriptionItem = new PrescriptionItem();
        prescriptionItem.setId(prescriptionItemDTO.getId());
        prescriptionItem.setPrescription(prescription);
        prescriptionItem.setMedication(prescriptionItemDTO.getMedication());
        prescriptionItem.setDosage(prescriptionItemDTO.getDosage());
        prescriptionItem.setQuantity(prescriptionItemDTO.getQuantity());
        return prescriptionItem;
    }
}
