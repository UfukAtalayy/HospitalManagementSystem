package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.MedicalRecordDTO;
import com.example.hospitalmanagement.Entity.MedicalRecord;
import com.example.hospitalmanagement.Entity.Patient;
import com.example.hospitalmanagement.Mapper.MedicalRecordMapper;
import com.example.hospitalmanagement.Repository.MedicalRecordRepository;
import com.example.hospitalmanagement.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private MedicalRecordMapper medicalRecordMapper;

    @Autowired
    private PatientRepository patientRepository;

    public List<MedicalRecordDTO> getAllMedicalRecords(){
        return medicalRecordRepository.findAll()
                .stream()
                .map(medicalRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MedicalRecordDTO getMedicalRecordById(Long id){
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Medical record not found with id:"+id));
        return medicalRecordMapper.toDTO(medicalRecord);
    }

    public MedicalRecordDTO createMedicalRecord(MedicalRecordDTO medicalRecordDTO){
        Patient patient = patientRepository.findById(medicalRecordDTO.getPatientId())
                .orElseThrow(()->new RuntimeException("Patient not found"));

        MedicalRecord medicalRecord = medicalRecordMapper.toEntity(medicalRecordDTO,patient);
        return medicalRecordMapper.toDTO(medicalRecordRepository.save(medicalRecord));
    }

   public MedicalRecordDTO updateMedicalRecord(Long id,MedicalRecordDTO dto){
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Medical record not found"));
        medicalRecord.setDiagnosis(dto.getDiagnosis());
        medicalRecord.setTreatment(dto.getTreatment());
        medicalRecord.setTestResults(dto.getTestResults());
        medicalRecord.setCreatedAt(dto.getCreatedAt());

        Patient patientId = patientRepository.findById(dto.getPatientId())
                .orElseThrow(()->new RuntimeException("Patient not found"));
        medicalRecord.setPatient(patientId);

        return medicalRecordMapper.toDTO(medicalRecordRepository.save(medicalRecord));
   }

    public void deleteMedicalRecord(Long id){
        medicalRecordRepository.deleteById(id);
    }
}
