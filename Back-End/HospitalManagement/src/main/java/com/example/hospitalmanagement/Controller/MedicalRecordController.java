package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.MedicalRecordDTO;
import com.example.hospitalmanagement.Service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicalrecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping
    public List<MedicalRecordDTO> getAllMedicalRecords(){
        return medicalRecordService.getAllMedicalRecords();
    }

    @GetMapping("/{id}")
    public MedicalRecordDTO getMedicalRecordById(@PathVariable Long id){
        return medicalRecordService.getMedicalRecordById(id);
    }

    @PostMapping
    public MedicalRecordDTO createMedicalRecord(@RequestBody MedicalRecordDTO medicalRecordDTO){
        return medicalRecordService.createMedicalRecord(medicalRecordDTO);
    }

  @PutMapping("/{id}")
  public MedicalRecordDTO updateMedicalRecord(@PathVariable Long id,@RequestBody MedicalRecordDTO medicalRecordDTO){
        return medicalRecordService.updateMedicalRecord(id, medicalRecordDTO);
  }

    @DeleteMapping("/{id}")
    public void deleteMedicalRecord(@PathVariable Long id){
        medicalRecordService.deleteMedicalRecord(id);
    }
}
