package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.DoctorNoteDTO;
import com.example.hospitalmanagement.Entity.Doctor;
import com.example.hospitalmanagement.Entity.DoctorNote;
import com.example.hospitalmanagement.Entity.Patient;
import com.example.hospitalmanagement.Mapper.DoctorNoteMapper;
import com.example.hospitalmanagement.Repository.DoctorNoteRepository;
import com.example.hospitalmanagement.Repository.DoctorRepository;
import com.example.hospitalmanagement.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorNoteService {

    @Autowired
    private DoctorNoteRepository doctorNoteRepository;

    @Autowired
    private DoctorNoteMapper doctorNoteMapper;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorNoteDTO> getAllDoctorNotes() {
        return doctorNoteRepository.findAll()
                .stream()
                .map(doctorNoteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DoctorNoteDTO getDoctorNoteById(Long id){
        DoctorNote doctorNote = doctorNoteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Doctor note not found with id"+id));
        return doctorNoteMapper.toDTO(doctorNote);
    }

    public DoctorNoteDTO createDoctorNote(DoctorNoteDTO doctorNoteDTO){
        Patient patient = patientRepository.findById(doctorNoteDTO.getPatientId())
                .orElseThrow(()->new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(doctorNoteDTO.getDoctorId())
                .orElseThrow(()->new RuntimeException("Doctor not found"));

        DoctorNote doctorNote = doctorNoteMapper.toEntity(doctorNoteDTO,patient,doctor);
        return doctorNoteMapper.toDTO(doctorNoteRepository.save(doctorNote));
    }

    public DoctorNoteDTO updateDoctorNote(Long id,DoctorNoteDTO dto){
        DoctorNote doctorNote = doctorNoteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Doctor note not found"));
        doctorNote.setNotes(dto.getNotes());
        doctorNote.setCreatedAt(dto.getCreatedAt());

        Patient patientId = patientRepository.findById(dto.getPatientId())
                .orElseThrow(()->new RuntimeException("Patient not found"));
        doctorNote.setPatient(patientId);

        Doctor doctorId = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(()->new RuntimeException("Doctor not found"));
        doctorNote.setDoctor(doctorId);

        return doctorNoteMapper.toDTO(doctorNoteRepository.save(doctorNote));
    }

    public void deleteDoctorNote(Long id){
        doctorNoteRepository.deleteById(id);
    }
}
