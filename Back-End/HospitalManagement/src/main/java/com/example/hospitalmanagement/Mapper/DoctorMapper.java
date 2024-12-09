package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.DoctorDTO;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public DoctorDTO toDTO(Doctor doctor){
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setUserId(doctor.getUser().getId());
        dto.setSpecialization(doctor.getSpeacialization());
        dto.setExperienceYears(doctor.getExperienceYears());
        dto.setPhone(doctor.getPhone());
        return dto;
    }

    public Doctor toEntity(DoctorDTO doctorDTO, User user){
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setUser(user);
        doctor.setSpeacialization(doctorDTO.getSpecialization());
        doctor.setExperienceYears(doctorDTO.getExperienceYears());
        doctor.setPhone(doctorDTO.getPhone());
        return doctor;
    }
}
