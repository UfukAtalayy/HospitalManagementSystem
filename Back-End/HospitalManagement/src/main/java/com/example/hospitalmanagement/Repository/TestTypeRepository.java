package com.example.hospitalmanagement.Repository;

import com.example.hospitalmanagement.Entity.TestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTypeRepository extends JpaRepository<TestType,Long> {
}
