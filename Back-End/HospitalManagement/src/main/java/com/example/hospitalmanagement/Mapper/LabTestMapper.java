package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.LabTestDTO;
import com.example.hospitalmanagement.Entity.*;
import org.springframework.stereotype.Component;

@Component
public class LabTestMapper {

    public LabTestDTO toDTO(LabTest labTest){
        LabTestDTO dto = new LabTestDTO();
        dto.setId(labTest.getId());
        dto.setPatientId(labTest.getPatient().getId());
        dto.setDoctorId(labTest.getDoctor().getId());
        dto.setTestName(labTest.getTestName());
        dto.setTestDate(labTest.getTestDate());
        dto.setResults(labTest.getResults());
        dto.setStatusId(labTest.getTestStatus().getId());
        dto.setLabStaffId(labTest.getLabStaff().getId());
        return dto;
    }

    public LabTest toEntity(LabTestDTO labTestDTO, Patient patient, Doctor doctor, TestStatus testStatus, LabStaff labStaff){
        LabTest labTest = new LabTest();
        labTest.setId(labTestDTO.getId());
        labTest.setPatient(patient);
        labTest.setDoctor(doctor);
        labTest.setTestName(labTestDTO.getTestName());
        labTest.setTestDate(labTestDTO.getTestDate());
        labTest.setResults(labTestDTO.getResults());
        labTest.setTestStatus(testStatus);
        labTest.setLabStaff(labStaff);
        return labTest;
    }
}
