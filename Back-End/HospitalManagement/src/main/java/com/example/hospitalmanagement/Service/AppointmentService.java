package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.AppointmentDTO;
import com.example.hospitalmanagement.Entity.Appointment;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.Patient;
import com.example.hospitalmanagement.Mapper.AppointmentMapper;
import com.example.hospitalmanagement.Repository.AppointmentRepository;
import com.example.hospitalmanagement.Repository.DoctorRepository;
import com.example.hospitalmanagement.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<AppointmentDTO> getAllAppointments(){
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id;"+id));
        return appointmentMapper.toDTO(appointment);
    }

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO){
        Patient patient = patientRepository.findById(appointmentDTO.getPatientId())
                .orElseThrow(()-> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(appointmentDTO.getDoctorId())
                .orElseThrow(()-> new RuntimeException("Doctor not found"));

        Appointment appointment = appointmentMapper.toEntity(appointmentDTO,doctor,patient);
        return appointmentMapper.toDTO(appointmentRepository.save(appointment));
    }

    public AppointmentDTO updateAppointment(Long id,AppointmentDTO dto){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Appointment not found"));
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setStatus(dto.getStatus());
        appointment.setNotes(dto.getNotes());

        Patient patientId = patientRepository.findById(dto.getPatientId())
                .orElseThrow(()->new RuntimeException("Patient not found"));
        appointment.setPatient(patientId);

        Doctor doctorId = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(()-> new RuntimeException("Doctor not found"));
        appointment.setDoctor(doctorId);
        return appointmentMapper.toDTO(appointmentRepository.save(appointment));
    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }
}
