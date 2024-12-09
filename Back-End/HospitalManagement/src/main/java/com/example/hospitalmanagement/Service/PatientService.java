package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.PatientDTO;
import com.example.hospitalmanagement.Entity.Patient;
import com.example.hospitalmanagement.Entity.User;
import com.example.hospitalmanagement.Mapper.PatientMapper;
import com.example.hospitalmanagement.Repository.PatientRepository;
import com.example.hospitalmanagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private UserRepository userRepository;


    public List<PatientDTO> getAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id"+ id));
        return patientMapper.toDTO(patient);
    }

    public PatientDTO createPatient(PatientDTO patientDTO){
        User user = userRepository.findById(patientDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Patient patient = patientMapper.toEntity(patientDTO,user);
        return patientMapper.toDTO(patientRepository.save(patient));
    }

    public PatientDTO updatePatient(Long id,PatientDTO dto){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setGender(dto.getGender());

        User userId = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        patient.setUser(userId);
        return patientMapper.toDTO(patientRepository.save(patient));
    }

    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }

}
