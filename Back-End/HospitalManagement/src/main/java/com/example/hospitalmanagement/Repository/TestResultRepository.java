package com.example.hospitalmanagement.Repository;

import com.example.hospitalmanagement.Entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult,Long> {
}
