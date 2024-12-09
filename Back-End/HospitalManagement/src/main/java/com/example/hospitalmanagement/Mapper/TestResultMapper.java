package com.example.hospitalmanagement.Mapper;

import com.example.hospitalmanagement.DTO.TestResultDTO;
import com.example.hospitalmanagement.Entity.LabTest;
import com.example.hospitalmanagement.Entity.TestResult;
import org.springframework.stereotype.Component;

@Component
public class TestResultMapper {

    public TestResultDTO toDTO(TestResult testResult){
        TestResultDTO dto = new TestResultDTO();
        dto.setId(testResult.getId());
        dto.setLabTestId(testResult.getLabTest().getId());
        dto.setResultFilePath(testResult.getResultFilePath());
        dto.setUploadedAt(testResult.getUploadedAt());
        return dto;
    }

    public TestResult toEntity(TestResultDTO testResultDTO, LabTest labTest){
        TestResult testResult = new TestResult();
        testResult.setId(testResultDTO.getId());
        testResult.setLabTest(labTest);
        testResult.setResultFilePath(testResultDTO.getResultFilePath());
        testResult.setUploadedAt(testResultDTO.getUploadedAt());
        return testResult;
    }
}
