package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.DoctorNoteDTO;
import com.example.hospitalmanagement.Service.DoctorNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctornotes")
public class DoctorNoteController {

    @Autowired
    private DoctorNoteService doctorNoteService;

    @GetMapping
    public List<DoctorNoteDTO> getAllDoctorNotes(){
        return doctorNoteService.getAllDoctorNotes();
    }

    @GetMapping("/{id}")
    public DoctorNoteDTO getAllDoctorNoteById(@PathVariable Long id){
        return doctorNoteService.getDoctorNoteById(id);
    }

    @PostMapping
    public DoctorNoteDTO createDoctorNote(@RequestBody DoctorNoteDTO doctorNoteDTO){
        return doctorNoteService.createDoctorNote(doctorNoteDTO);
    }

    @PutMapping("/{id}")
    public DoctorNoteDTO updateDoctorNote(@PathVariable Long id,@RequestBody DoctorNoteDTO doctorNoteDTO){
        return doctorNoteService.updateDoctorNote(id, doctorNoteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorNote(@PathVariable Long id){
        doctorNoteService.deleteDoctorNote(id);
    }

}
