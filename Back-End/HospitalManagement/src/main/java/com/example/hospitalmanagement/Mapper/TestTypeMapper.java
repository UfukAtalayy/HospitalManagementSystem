package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.TestTypeDTO;
import com.example.hospitalmanagement.Entity.TestType;
import org.springframework.stereotype.Component;

@Component
public class TestTypeMapper {

    public TestTypeDTO toDTO(TestType testType){
        TestTypeDTO dto = new TestTypeDTO();
        dto.setId(testType.getId());
        dto.setName(testType.getName());
        dto.setDescription(testType.getDescription());
        return dto;
    }

    public TestType toEntity(TestTypeDTO testTypeDTO){
        TestType testType = new TestType();
        testType.setId(testTypeDTO.getId());
        testType.setName(testTypeDTO.getName());
        testType.setDescription(testTypeDTO.getDescription());
        return testType;
    }
}
