package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.TestStatusDTO;
import com.example.hospitalmanagement.Service.TestStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teststatus")
public class TestStatusController {

    @Autowired
    private TestStatusService testStatusService;

    @GetMapping
    public List<TestStatusDTO> getAllTestStatus(){
        return testStatusService.getAllTestStatus();
    }

    @GetMapping("/{id}")
    public TestStatusDTO getTestStatusById(@PathVariable Long id){
        return testStatusService.getTestStatusById(id);
    }

    @PostMapping
    public TestStatusDTO createTestStatus(@RequestBody TestStatusDTO testStatusDTO){
        return testStatusService.createTestStatus(testStatusDTO);
    }

    @PutMapping("/{id}")
    public TestStatusDTO updateTestStatus(@PathVariable Long id,@RequestBody TestStatusDTO testStatusDTO){
        return testStatusService.updateTestStatus(id, testStatusDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTestStatus(@PathVariable Long id){
        testStatusService.deleteTestStatus(id);
    }
}
