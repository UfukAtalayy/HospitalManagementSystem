package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.MedicalRecordDTO;
import com.example.hospitalmanagement.Entity.MedicalRecord;
import com.example.hospitalmanagement.Entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecordMapper {

    public MedicalRecordDTO toDTO(MedicalRecord medicalRecord){
        MedicalRecordDTO dto = new MedicalRecordDTO();
        dto.setId(medicalRecord.getId());
        dto.setPatientId(medicalRecord.getPatient().getId());
        dto.setTreatment(medicalRecord.getTreatment());
        dto.setDiagnosis(medicalRecord.getDiagnosis());
        dto.setTestResults(medicalRecord.getTestResults());
        dto.setCreatedAt(medicalRecord.getCreatedAt());
        return dto;
    }

    public MedicalRecord toEntity(MedicalRecordDTO medicalRecordDTO, Patient patient){
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setId(medicalRecordDTO.getId());
        medicalRecord.setPatient(patient);
        medicalRecord.setTreatment(medicalRecordDTO.getTreatment());
        medicalRecord.setDiagnosis(medicalRecordDTO.getDiagnosis());
        medicalRecord.setTestResults(medicalRecordDTO.getTestResults());
        medicalRecord.setCreatedAt(medicalRecordDTO.getCreatedAt());
        return medicalRecord;
    }
}
