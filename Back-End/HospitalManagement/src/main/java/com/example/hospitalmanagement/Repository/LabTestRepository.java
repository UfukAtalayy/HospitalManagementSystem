package com.example.hospitalmanagement.Repository;

import com.example.hospitalmanagement.Entity.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest,Long> {
}
