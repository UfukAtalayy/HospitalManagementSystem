package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.PatientDTO;
import com.example.hospitalmanagement.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<PatientDTO> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientDTO patientDTO){
        return patientService.createPatient(patientDTO);
    }

    @PutMapping("/{id}")
    public PatientDTO updatePatient(@PathVariable Long id,@RequestBody PatientDTO patientDTO){
        return patientService.updatePatient(id, patientDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }
}
