package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.LabTestDTO;
import com.example.hospitalmanagement.Entity.*;
import com.example.hospitalmanagement.Mapper.LabTestMapper;
import com.example.hospitalmanagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabTestService {

    @Autowired
    private LabTestRepository labTestRepository;

    @Autowired
    private LabTestMapper labTestMapper;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private TestStatusRepository testStatusRepository;

    @Autowired
    private LabStaffRepository labStaffRepository;

    public List<LabTestDTO> getAllLabTests(){
        return labTestRepository.findAll()
                .stream()
                .map(labTestMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LabTestDTO getLabTestById(Long id){
        LabTest labTest =  labTestRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Labtest not found with id:"+id));
        return labTestMapper.toDTO(labTest);
    }

    public LabTestDTO createLabTest(LabTestDTO labTestDTO){
        Patient patient = patientRepository.findById(labTestDTO.getPatientId())
                .orElseThrow(()-> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(labTestDTO.getDoctorId())
                .orElseThrow(()-> new RuntimeException("Doctor not found"));

        TestStatus testStatus = testStatusRepository.findById(labTestDTO.getStatusId())
                .orElseThrow(()->new RuntimeException("Test status not found"));

        LabStaff labStaff = labStaffRepository.findById(labTestDTO.getLabStaffId())
                .orElseThrow(()->new RuntimeException("Lab staff not found"));

        LabTest labTest = labTestMapper.toEntity(labTestDTO,patient,doctor,testStatus,labStaff);
        return labTestMapper.toDTO(labTestRepository.save(labTest));
    }

    public LabTestDTO updateLabTest(Long id,LabTestDTO dto){
        LabTest labTest = labTestRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Labtest not found"));
        labTest.setTestName(dto.getTestName());
        labTest.setTestDate(dto.getTestDate());
        labTest.setResults(dto.getResults());

        Patient patientId = patientRepository.findById(dto.getPatientId())
                .orElseThrow(()-> new RuntimeException("Patient not found"));
        labTest.setPatient(patientId);

        Doctor doctorId = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(()-> new RuntimeException("Doctor not found"));
        labTest.setDoctor(doctorId);

        TestStatus testStatusId = testStatusRepository.findById(dto.getStatusId())
                .orElseThrow(()->new RuntimeException("Test status not found"));
        labTest.setTestStatus(testStatusId);

        LabStaff labStaffId = labStaffRepository.findById(dto.getLabStaffId())
                .orElseThrow(()->new RuntimeException("Lab staff not found"));
        labTest.setLabStaff(labStaffId);

        return labTestMapper.toDTO(labTestRepository.save(labTest));
    }

    public void deleteLabTest(Long id){
        labTestRepository.deleteById(id);
    }
}
