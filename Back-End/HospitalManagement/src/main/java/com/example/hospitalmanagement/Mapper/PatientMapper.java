package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.PatientDTO;
import com.example.hospitalmanagement.Entity.Patient;
import com.example.hospitalmanagement.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientDTO toDTO(Patient patient){
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setUserId(patient.getUser().getId());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setGender(patient.getGender());
        return dto;
    }

    public Patient toEntity(PatientDTO patientDTO, User user){
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setUser(user);
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setGender(patientDTO.getGender());
        return patient;
    }

}
