package com.example.hospitalmanagement.Repository;

import com.example.hospitalmanagement.Entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability,Long> {
}
