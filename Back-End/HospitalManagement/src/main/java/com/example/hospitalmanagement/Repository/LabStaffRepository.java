package com.example.hospitalmanagement.Repository;

import com.example.hospitalmanagement.Entity.LabStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabStaffRepository extends JpaRepository<LabStaff,Long> {
}
