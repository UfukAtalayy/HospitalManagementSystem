package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.PrescriptionDTO;
import com.example.hospitalmanagement.Entity.Appointment;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.Patient;
import com.example.hospitalmanagement.Entity.Prescription;
import org.springframework.stereotype.Component;

@Component
public class PrescriptionMapper {

    public PrescriptionDTO toDTO(Prescription prescription){
        PrescriptionDTO dto = new PrescriptionDTO();
        dto.setId(prescription.getId());
        dto.setAppointmentId(prescription.getAppointment().getId());
        dto.setDoctorId(prescription.getDoctor().getId());
        dto.setPatientId(prescription.getPatient().getId());
        dto.setMedication(prescription.getMedication());
        dto.setDosage(prescription.getDosage());
        dto.setInstructions(prescription.getInstructions());
        return dto;
    }

    public Prescription toEntity(PrescriptionDTO prescriptionDTO, Appointment appointment, Doctor doctor, Patient patient){
        Prescription prescription = new Prescription();
        prescription.setId(prescriptionDTO.getId());
        prescription.setAppointment(appointment);
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setMedication(prescriptionDTO.getMedication());
        prescription.setDosage(prescriptionDTO.getDosage());
        prescription.setInstructions(prescriptionDTO.getInstructions());
        return prescription;
    }
}
