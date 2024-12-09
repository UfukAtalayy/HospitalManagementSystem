package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.TestResultDTO;
import com.example.hospitalmanagement.Service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testresult")
public class TestResultController {

    @Autowired
    private TestResultService testResultService;

    @GetMapping
    public List<TestResultDTO> getAllTestResults(){
        return testResultService.getAllTestResults();
    }

    @GetMapping("/{id}")
    public TestResultDTO getTestResultById(@PathVariable Long id){
        return testResultService.getTestResultById(id);
    }

    @PostMapping
    public TestResultDTO createTestResult(@RequestBody TestResultDTO testResultDTO){
        return testResultService.createTestResult(testResultDTO);
    }

    @PutMapping("/{id}")
    public TestResultDTO updateTestResult(@PathVariable Long id,@RequestBody TestResultDTO testResultDTO){
        return testResultService.updateTestResult(id,testResultDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTestResult(@PathVariable Long id){
        testResultService.deleteTestResult(id);
    }

}
