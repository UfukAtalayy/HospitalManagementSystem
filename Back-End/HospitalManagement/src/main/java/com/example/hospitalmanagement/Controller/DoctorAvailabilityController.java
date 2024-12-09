package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.DoctorAvailabilityDTO;
import com.example.hospitalmanagement.Service.DoctorAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctoravailability")
public class DoctorAvailabilityController {

    @Autowired
    private DoctorAvailabilityService doctorAvailabilityService;

    @GetMapping
    public List<DoctorAvailabilityDTO> getAllDoctorAvailability(){
        return doctorAvailabilityService.getAllDoctorAvailability();
    }

    @GetMapping("/{id}")
    public DoctorAvailabilityDTO getDoctorAvalilabilityById(@PathVariable Long id){
        return doctorAvailabilityService.getDoctorAvailabilityById(id);
    }

    @PostMapping
    public DoctorAvailabilityDTO createDoctorAvailability(@RequestBody DoctorAvailabilityDTO doctorAvailabilityDTO){
        return doctorAvailabilityService.createDoctorAvailability(doctorAvailabilityDTO);
    }

    @PutMapping("/{id}")
    public DoctorAvailabilityDTO updateDoctorAvailability(@PathVariable Long id,@RequestBody DoctorAvailabilityDTO doctorAvailabilityDTO){
        return doctorAvailabilityService.updateDoctorAvailability(id, doctorAvailabilityDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorAvailability(@PathVariable Long id){
        doctorAvailabilityService.deleteDoctorAvailability(id);
    }
}
