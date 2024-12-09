package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.TestResultDTO;
import com.example.hospitalmanagement.Entity.LabTest;
import com.example.hospitalmanagement.Entity.TestResult;
import com.example.hospitalmanagement.Mapper.TestResultMapper;
import com.example.hospitalmanagement.Repository.LabTestRepository;
import com.example.hospitalmanagement.Repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestResultService {

    @Autowired
    private TestResultRepository testResultRepository;

    @Autowired
    private TestResultMapper testResultMapper;

    @Autowired
    private LabTestRepository labTestRepository;

    public List<TestResultDTO> getAllTestResults(){
        return testResultRepository.findAll()
                .stream()
                .map(testResultMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TestResultDTO getTestResultById(Long id){
        TestResult testResult = testResultRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Test result not found with id"+id));
        return testResultMapper.toDTO(testResult);
    }

    public TestResultDTO createTestResult(TestResultDTO testResultDTO){
        LabTest labTest = labTestRepository.findById(testResultDTO.getLabTestId())
                .orElseThrow(()->new RuntimeException("Lab test not found"));

        TestResult testResult = testResultMapper.toEntity(testResultDTO,labTest);
        return testResultMapper.toDTO(testResultRepository.save(testResult));
    }

    public TestResultDTO updateTestResult(Long id,TestResultDTO dto){
        TestResult testResult = testResultRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Test result not found"));
        testResult.setResultFilePath(dto.getResultFilePath());
        testResult.setUploadedAt(dto.getUploadedAt());

        LabTest labTestId = labTestRepository.findById(dto.getLabTestId())
                .orElseThrow(()->new RuntimeException("Lab test not found"));
        testResult.setLabTest(labTestId);

        return testResultMapper.toDTO(testResultRepository.save(testResult));
    }

    public void deleteTestResult(Long id){
        testResultRepository.deleteById(id);
    }
}
