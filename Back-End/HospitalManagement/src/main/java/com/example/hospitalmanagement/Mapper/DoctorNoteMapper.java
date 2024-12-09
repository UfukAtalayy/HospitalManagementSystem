package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.DoctorNoteDTO;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.DoctorNote;
import com.example.hospitalmanagement.Entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class DoctorNoteMapper {

    public DoctorNoteDTO toDTO(DoctorNote doctorNote){
        DoctorNoteDTO dto = new DoctorNoteDTO();
        dto.setId(doctorNote.getId());
        dto.setPatientId(doctorNote.getPatient().getId());
        dto.setDoctorId(doctorNote.getDoctor().getId());
        dto.setNotes(doctorNote.getNotes());
        dto.setCreatedAt(doctorNote.getCreatedAt());
        return dto;
    }

    public DoctorNote toEntity(DoctorNoteDTO doctorNoteDTO, Patient patient, Doctor doctor){
        DoctorNote doctorNote = new DoctorNote();
        doctorNote.setId(doctorNoteDTO.getId());
        doctorNote.setPatient(patient);
        doctorNote.setDoctor(doctor);
        doctorNote.setNotes(doctorNoteDTO.getNotes());
        doctorNote.setCreatedAt(doctorNoteDTO.getCreatedAt());
        return doctorNote;
    }
}
