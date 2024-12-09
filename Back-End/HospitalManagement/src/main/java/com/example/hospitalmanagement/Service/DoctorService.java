package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.DoctorDTO;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.User;
import com.example.hospitalmanagement.Mapper.DoctorMapper;
import com.example.hospitalmanagement.Repository.DoctorRepository;
import com.example.hospitalmanagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private UserRepository userRepository;

    public List<DoctorDTO> getAllDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id"+ id));
        return doctorMapper.toDTO(doctor);
    }

    public DoctorDTO createDoctor(DoctorDTO doctorDTO){
        User user = userRepository.findById(doctorDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Doctor doctor = doctorMapper.toEntity(doctorDTO,user);
        return doctorMapper.toDTO(doctorRepository.save(doctor));
    }

    public DoctorDTO updateDoctor(Long id,DoctorDTO dto){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        doctor.setSpeacialization(dto.getSpecialization());
        doctor.setExperienceYears(dto.getExperienceYears());
        doctor.setPhone(dto.getPhone());

        User userId = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        doctor.setUser(userId);
        return doctorMapper.toDTO(doctorRepository.save(doctor));
    }

    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }
}
