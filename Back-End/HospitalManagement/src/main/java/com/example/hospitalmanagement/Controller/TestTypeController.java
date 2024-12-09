package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.TestTypeDTO;
import com.example.hospitalmanagement.Service.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testtype")
public class TestTypeController {

    @Autowired
    private TestTypeService testTypeService;

    @GetMapping
    public List<TestTypeDTO> getAllTestTypes(){
        return testTypeService.getAllTestTypes();
    }

    @GetMapping("/{id}")
    public TestTypeDTO getTestTypeById(@PathVariable Long id){
        return testTypeService.getTestTypeById(id);
    }

    @PostMapping
    public TestTypeDTO createTestType(@RequestBody TestTypeDTO testTypeDTO){
        return testTypeService.createTestType(testTypeDTO);
    }

    @PutMapping("/{id}")
    public TestTypeDTO updateTestType(@PathVariable Long id,@RequestBody TestTypeDTO testTypeDTO){
        return testTypeService.updateTestType(id, testTypeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTestType(@PathVariable Long id){
        testTypeService.deleteTestType(id);
    }
}
