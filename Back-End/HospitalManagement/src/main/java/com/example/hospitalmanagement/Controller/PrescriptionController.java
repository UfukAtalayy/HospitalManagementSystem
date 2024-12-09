package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.PrescriptionDTO;
import com.example.hospitalmanagement.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping
    public List<PrescriptionDTO> getAllPrescriptions(){
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/{id}")
    public PrescriptionDTO getPrescriptionById(@PathVariable Long id){
        return prescriptionService.getPrescriptionById(id);
    }

    @PostMapping
    public PrescriptionDTO createPrescription(@RequestBody PrescriptionDTO prescriptionDTO){
        return prescriptionService.createPrescription(prescriptionDTO);
    }

    @PutMapping("/{id}")
    public PrescriptionDTO updatePrescription(@PathVariable Long id,@RequestBody PrescriptionDTO prescriptionDTO){
        return prescriptionService.updatePrescription(id, prescriptionDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable Long id){
        prescriptionService.deletePrescription(id);
    }
}
