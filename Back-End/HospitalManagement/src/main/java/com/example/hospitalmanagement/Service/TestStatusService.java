package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.TestStatusDTO;
import com.example.hospitalmanagement.Entity.TestStatus;
import com.example.hospitalmanagement.Mapper.TestStatusMapper;
import com.example.hospitalmanagement.Repository.TestStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestStatusService {

    @Autowired
    private TestStatusRepository testStatusRepository;

    @Autowired
    private TestStatusMapper testStatusMapper;

    public List<TestStatusDTO> getAllTestStatus(){
        return testStatusRepository.findAll()
                .stream()
                .map(testStatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TestStatusDTO getTestStatusById(Long id){
        TestStatus testStatus = testStatusRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Test status not found with id:"+id));

        return testStatusMapper.toDTO(testStatus);
    }

    public TestStatusDTO createTestStatus(TestStatusDTO testStatusDTO){
        TestStatus testStatus = testStatusMapper.toEntity(testStatusDTO);
        return testStatusMapper.toDTO(testStatusRepository.save(testStatus));
    }

    public TestStatusDTO updateTestStatus(Long id,TestStatusDTO testStatusDTO){
        TestStatus testStatus = testStatusRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Test status not found"));
        testStatus.setName(testStatusDTO.getName());

        return testStatusMapper.toDTO(testStatusRepository.save(testStatus));
    }

    public void deleteTestStatus(Long id){
        testStatusRepository.deleteById(id);
    }
}
