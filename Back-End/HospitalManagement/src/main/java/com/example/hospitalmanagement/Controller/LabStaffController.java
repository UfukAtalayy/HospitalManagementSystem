package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.LabStaffDTO;
import com.example.hospitalmanagement.Service.LabStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labstaff")
public class LabStaffController {

    @Autowired
    private LabStaffService labStaffService;

    @GetMapping
    public List<LabStaffDTO> getAllLabStaff(){
        return labStaffService.getAllLabStaff();
    }

    @GetMapping("/{id}")
    public LabStaffDTO getLabStaffById(@PathVariable Long id){
        return labStaffService.getLabStaffById(id);
    }

    @PostMapping
    public LabStaffDTO createLabStaff(@RequestBody LabStaffDTO labStaffDTO){
        return labStaffService.createLabStaff(labStaffDTO);
    }

    @PutMapping("/{id}")
    public LabStaffDTO updateLabStaff(@PathVariable Long id,@RequestBody LabStaffDTO labStaffDTO){
        return labStaffService.updateLabStaff(id, labStaffDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLabStaff(@PathVariable Long id){
        labStaffService.deleteLabStaff(id);
    }
}
