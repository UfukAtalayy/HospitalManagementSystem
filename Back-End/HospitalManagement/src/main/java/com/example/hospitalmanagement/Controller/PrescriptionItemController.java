package com.example.hospitalmanagement.Controller;

import com.example.hospitalmanagement.DTO.PrescriptionItemDTO;
import com.example.hospitalmanagement.Service.PrescriptionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptionitem")
public class PrescriptionItemController {

    @Autowired
    private PrescriptionItemService prescriptionItemService;

    @GetMapping
    public List<PrescriptionItemDTO> getAllPrescriptionItems(){
        return prescriptionItemService.getAllPrescriptionItems();
    }

    @GetMapping("/{id}")
    public PrescriptionItemDTO getPrescriptionItemById(@PathVariable Long id){
        return prescriptionItemService.getPrescriptionItemById(id);
    }

    @PostMapping
    public PrescriptionItemDTO createPrescritionItem(@RequestBody PrescriptionItemDTO prescriptionItemDTO){
        return prescriptionItemService.createPrescriptionItem(prescriptionItemDTO);
    }

    @PutMapping("/{id}")
    public PrescriptionItemDTO updatePrescriptionItem(@PathVariable Long id,@RequestBody PrescriptionItemDTO prescriptionItemDTO){
        return prescriptionItemService.updatePrescriptionItem(id, prescriptionItemDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePrescriptionItem(@PathVariable Long id){
        prescriptionItemService.deletePrescriptionItem(id);
    }
}
