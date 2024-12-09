package com.example.hospitalmanagement.Service;

import com.example.hospitalmanagement.DTO.PrescriptionItemDTO;
import com.example.hospitalmanagement.Entity.Prescription;
import com.example.hospitalmanagement.Entity.PrescriptionItem;
import com.example.hospitalmanagement.Mapper.PrescriptionItemMapper;
import com.example.hospitalmanagement.Repository.PrescriptionItemRepository;
import com.example.hospitalmanagement.Repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionItemService {

    @Autowired
    private PrescriptionItemRepository prescriptionItemRepository;

    @Autowired
    private PrescriptionItemMapper prescriptionItemMapper;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<PrescriptionItemDTO> getAllPrescriptionItems(){
        return prescriptionItemRepository.findAll()
                .stream()
                .map(prescriptionItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PrescriptionItemDTO getPrescriptionItemById(Long id){
        PrescriptionItem prescriptionItem = prescriptionItemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Prescription item not found with id:"+id));
        return prescriptionItemMapper.toDTO(prescriptionItem);
    }

    public PrescriptionItemDTO createPrescriptionItem(PrescriptionItemDTO prescriptionItemDTO){
        Prescription prescription = prescriptionRepository.findById(prescriptionItemDTO.getPrescriptionId())
                .orElseThrow(()->new RuntimeException("Prescription not found"));

        PrescriptionItem prescriptionItem = prescriptionItemMapper.toEntity(prescriptionItemDTO,prescription);
        return prescriptionItemMapper.toDTO(prescriptionItemRepository.save(prescriptionItem));
    }

    public PrescriptionItemDTO updatePrescriptionItem(Long id,PrescriptionItemDTO dto){
        PrescriptionItem prescriptionItem = prescriptionItemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Prescription item not found"));
        prescriptionItem.setMedication(dto.getMedication());
        prescriptionItem.setDosage(dto.getDosage());
        prescriptionItem.setQuantity(dto.getQuantity());

        Prescription prescriptionId = prescriptionRepository.findById(dto.getPrescriptionId())
                .orElseThrow(()->new RuntimeException("Prescription not found"));
        prescriptionItem.setPrescription(prescriptionId);

        return prescriptionItemMapper.toDTO(prescriptionItemRepository.save(prescriptionItem));
    }

    public void deletePrescriptionItem(Long id){
        prescriptionItemRepository.deleteById(id);
    }
}
