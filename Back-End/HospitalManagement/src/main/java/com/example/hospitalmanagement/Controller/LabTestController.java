package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.LabTestDTO;
import com.example.hospitalmanagement.Service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labtests")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    @GetMapping
    public List<LabTestDTO> getAllLabTests(){
        return labTestService.getAllLabTests();
    }

    @GetMapping("/{id}")
    public LabTestDTO getLabTestById(@PathVariable Long id){
        return labTestService.getLabTestById(id);
    }

    @PostMapping
    public LabTestDTO createLabTest(@RequestBody LabTestDTO labTestDTO){
        return labTestService.createLabTest(labTestDTO);
    }

    @PutMapping("/{id}")
    public LabTestDTO updateLabTest(@PathVariable Long id, @RequestBody LabTestDTO labTestDTO){
        return labTestService.updateLabTest(id, labTestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLabTest(@PathVariable Long id){
        labTestService.deleteLabTest(id);
    }

}
