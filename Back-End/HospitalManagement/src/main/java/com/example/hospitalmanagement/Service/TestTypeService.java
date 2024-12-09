package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.TestTypeDTO;
import com.example.hospitalmanagement.Entity.TestType;
import com.example.hospitalmanagement.Mapper.TestTypeMapper;
import com.example.hospitalmanagement.Repository.TestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestTypeService {

    @Autowired
    private TestTypeRepository testTypeRepository;

    @Autowired
    private TestTypeMapper testTypeMapper;

    public List<TestTypeDTO> getAllTestTypes(){
        return testTypeRepository.findAll()
                .stream()
                .map(testTypeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TestTypeDTO getTestTypeById(Long id){
        TestType testType = testTypeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Test type not found with id:"+id));
        return testTypeMapper.toDTO(testType);
    }

    public TestTypeDTO createTestType(TestTypeDTO testTypeDTO){
        TestType testType = testTypeMapper.toEntity(testTypeDTO);
        return testTypeMapper.toDTO(testTypeRepository.save(testType));
    }

    public TestTypeDTO updateTestType(Long id,TestTypeDTO dto){
        TestType testType = testTypeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Test type not found"));
        testType.setName(dto.getName());
        testType.setDescription(dto.getDescription());
        return testTypeMapper.toDTO(testTypeRepository.save(testType));
    }

    public void deleteTestType(Long id){
        testTypeRepository.deleteById(id);
    }
}
