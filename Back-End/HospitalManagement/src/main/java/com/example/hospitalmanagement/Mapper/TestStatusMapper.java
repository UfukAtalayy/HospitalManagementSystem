package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.TestStatusDTO;
import com.example.hospitalmanagement.Entity.TestStatus;
import org.springframework.stereotype.Component;

@Component
public class TestStatusMapper {

    public TestStatusDTO toDTO(TestStatus testStatus){
        TestStatusDTO dto = new TestStatusDTO();
        dto.setId(testStatus.getId());
        dto.setName(testStatus.getName());
        return dto;
    }

    public TestStatus toEntity(TestStatusDTO testStatusDTO){
        TestStatus testStatus = new TestStatus();
        testStatus.setId(testStatusDTO.getId());
        testStatus.setName(testStatusDTO.getName());
        return testStatus;
    }
}
