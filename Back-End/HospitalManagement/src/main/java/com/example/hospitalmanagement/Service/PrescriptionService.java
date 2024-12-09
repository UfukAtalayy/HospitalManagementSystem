package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.PrescriptionDTO;
import com.example.hospitalmanagement.Entity.Appointment;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.Patient;
import com.example.hospitalmanagement.Entity.Prescription;
import com.example.hospitalmanagement.Mapper.PrescriptionMapper;
import com.example.hospitalmanagement.Repository.AppointmentRepository;
import com.example.hospitalmanagement.Repository.DoctorRepository;
import com.example.hospitalmanagement.Repository.PatientRepository;
import com.example.hospitalmanagement.Repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PrescriptionMapper prescriptionMapper;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<PrescriptionDTO> getAllPrescriptions(){
        return prescriptionRepository.findAll()
                .stream()
                .map(prescriptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PrescriptionDTO getPrescriptionById(Long id){
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Prescription not found with id:"+id));
        return prescriptionMapper.toDTO(prescription);
    }

    public PrescriptionDTO createPrescription(PrescriptionDTO prescriptionDTO){
        Appointment appointment = appointmentRepository.findById(prescriptionDTO.getAppointmentId())
                .orElseThrow(()->new RuntimeException("Appointment not found"));
        Doctor doctor = doctorRepository.findById(prescriptionDTO.getDoctorId())
                .orElseThrow(()-> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(prescriptionDTO.getPatientId())
                .orElseThrow(()-> new RuntimeException("Patient not found"));

        Prescription prescription = prescriptionMapper.toEntity(prescriptionDTO,appointment,doctor,patient);
        return prescriptionMapper.toDTO(prescriptionRepository.save(prescription));
    }

    public PrescriptionDTO updatePrescription(Long id,PrescriptionDTO dto){
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Prescription not found"));
        prescription.setMedication(dto.getMedication());
        prescription.setDosage(dto.getDosage());
        prescription.setInstructions(dto.getInstructions());

        Appointment appointmentId = appointmentRepository.findById(dto.getAppointmentId())
                .orElseThrow(()->new RuntimeException("Appointment not found"));
        prescription.setAppointment(appointmentId);

        Doctor doctorId = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(()->new RuntimeException("Doctor not found"));
        prescription.setDoctor(doctorId);

        Patient patientId = patientRepository.findById(dto.getPatientId())
                .orElseThrow(()->new RuntimeException("Patient not found"));
        prescription.setPatient(patientId);
        return prescriptionMapper.toDTO(prescriptionRepository.save(prescription));
    }

    public void deletePrescription(Long id){
        prescriptionRepository.deleteById(id);
    }
}
