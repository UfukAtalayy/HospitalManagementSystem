package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.DoctorAvailabilityDTO;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.DoctorAvailability;
import org.springframework.stereotype.Component;

@Component
public class DoctorAvailabilityMapper {

    public DoctorAvailabilityDTO toDTO(DoctorAvailability doctorAvailability){
        DoctorAvailabilityDTO dto = new DoctorAvailabilityDTO();
        dto.setId(doctorAvailability.getId());
        dto.setDoctorId(doctorAvailability.getDoctor().getId());
        dto.setAvailableFrom(doctorAvailability.getAvailableFrom());
        dto.setAvailableTo(doctorAvailability.getAvailableTo());
        return dto;
    }

    public DoctorAvailability toEntity(DoctorAvailabilityDTO doctorAvailabilityDTO, Doctor doctor){
        DoctorAvailability doctorAvailability = new DoctorAvailability();
        doctorAvailability.setId(doctorAvailabilityDTO.getId());
        doctorAvailability.setDoctor(doctor);
        doctorAvailability.setAvailableFrom(doctorAvailabilityDTO.getAvailableFrom());
        doctorAvailability.setAvailableTo(doctorAvailabilityDTO.getAvailableTo());
        return doctorAvailability;
    }
}
