package com.example.hospitalmanagement.Repository;

import com.example.hospitalmanagement.Entity.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionItemRepository extends JpaRepository<PrescriptionItem,Long> {
}
