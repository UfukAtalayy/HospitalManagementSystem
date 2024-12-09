package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.LabStaffDTO;
import com.example.hospitalmanagement.Entity.LabStaff;
import com.example.hospitalmanagement.Mapper.LabStaffMapper;
import com.example.hospitalmanagement.Repository.LabStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabStaffService {
    @Autowired
    private LabStaffRepository labStaffRepository;

    @Autowired
    private LabStaffMapper labStaffMapper;

    public List<LabStaffDTO> getAllLabStaff(){
        return labStaffRepository.findAll()
                .stream()
                .map(labStaffMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LabStaffDTO getLabStaffById(Long id){
        LabStaff labStaff = labStaffRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Lab staff not found with id"+id));
        return labStaffMapper.toDTO(labStaff);
    }

    public LabStaffDTO createLabStaff(LabStaffDTO labStaffDTO){
        LabStaff labStaff = labStaffMapper.toEntity(labStaffDTO);
        return labStaffMapper.toDTO(labStaffRepository.save(labStaff));
    }

    public LabStaffDTO updateLabStaff(Long id, LabStaffDTO dto){
        LabStaff labStaff = labStaffRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Lab staff not found"));
        labStaff.setName(dto.getName());
        labStaff.setRole(dto.getRole());
        labStaff.setPhone(dto.getPhone());
        labStaff.setCreatedAt(dto.getCreatedAt());

        return labStaffMapper.toDTO(labStaffRepository.save(labStaff));
    }

    public void deleteLabStaff(Long id){
        labStaffRepository.deleteById(id);
    }
}
