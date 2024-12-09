package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.AppointmentDTO;
import com.example.hospitalmanagement.Entity.Appointment;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentDTO toDTO(Appointment appointment){
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setPatientId(appointment.getPatient().getId());
        dto.setDoctorId(appointment.getDoctor().getId());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setStatus(appointment.getStatus());
        dto.setNotes(appointment.getNotes());
        return dto;
    }

    public Appointment toEntity(AppointmentDTO appointmentDTO, Doctor doctor, Patient patient){
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setNotes(appointmentDTO.getNotes());
        return appointment;
    }
}
