package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.DoctorAvailabilityDTO;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.DoctorAvailability;
import com.example.hospitalmanagement.Mapper.DoctorAvailabilityMapper;
import com.example.hospitalmanagement.Repository.DoctorAvailabilityRepository;
import com.example.hospitalmanagement.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorAvailabilityService {

    @Autowired
    private DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Autowired
    private DoctorAvailabilityMapper doctorAvailabilityMapper;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorAvailabilityDTO> getAllDoctorAvailability(){
        return doctorAvailabilityRepository.findAll()
                .stream()
                .map(doctorAvailabilityMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DoctorAvailabilityDTO getDoctorAvailabilityById(Long id){
        DoctorAvailability doctorAvailability = doctorAvailabilityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Doctor availability not found with id"+id));
        return doctorAvailabilityMapper.toDTO(doctorAvailability);
    }

    public DoctorAvailabilityDTO createDoctorAvailability(DoctorAvailabilityDTO doctorAvailabilityDTO){
        Doctor doctor = doctorRepository.findById(doctorAvailabilityDTO.getDoctorId())
                .orElseThrow(()->new RuntimeException("Doctor not found"));

        DoctorAvailability doctorAvailability = doctorAvailabilityMapper.toEntity(doctorAvailabilityDTO,doctor);
        return doctorAvailabilityMapper.toDTO(doctorAvailabilityRepository.save(doctorAvailability));
    }

    public DoctorAvailabilityDTO updateDoctorAvailability(Long id,DoctorAvailabilityDTO dto){
        DoctorAvailability doctorAvailability = doctorAvailabilityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Doctor availability not found"));
        doctorAvailability.setAvailableFrom(dto.getAvailableFrom());
        doctorAvailability.setAvailableTo(dto.getAvailableTo());

        Doctor doctorId = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(()->new RuntimeException("Doctor not found"));
        doctorAvailability.setDoctor(doctorId);

        return doctorAvailabilityMapper.toDTO(doctorAvailabilityRepository.save(doctorAvailability));
    }

    public void deleteDoctorAvailability(Long id){
        doctorAvailabilityRepository.deleteById(id);
    }
}
