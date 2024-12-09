package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.LabStaffDTO;
import com.example.hospitalmanagement.Entity.LabStaff;
import org.springframework.stereotype.Component;

@Component
public class LabStaffMapper {

    public LabStaffDTO toDTO(LabStaff labStaff){
        LabStaffDTO dto = new LabStaffDTO();
        dto.setId(labStaff.getId());
        dto.setName(labStaff.getName());
        dto.setRole(labStaff.getRole());
        dto.setPhone(labStaff.getPhone());
        dto.setCreatedAt(labStaff.getCreatedAt());
        return dto;
    }

    public LabStaff toEntity(LabStaffDTO labStaffDTO){
        LabStaff labStaff = new LabStaff();
        labStaff.setId(labStaffDTO.getId());
        labStaff.setName(labStaffDTO.getName());
        labStaff.setRole(labStaffDTO.getRole());
        labStaff.setPhone(labStaffDTO.getPhone());
        labStaff.setCreatedAt(labStaffDTO.getCreatedAt());
        return labStaff;
    }
}
