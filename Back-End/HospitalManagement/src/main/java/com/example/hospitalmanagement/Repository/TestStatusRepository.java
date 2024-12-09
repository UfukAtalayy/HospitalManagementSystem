package com.example.hospitalmanagement.Repository;

import com.example.hospitalmanagement.Entity.TestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestStatusRepository extends JpaRepository<TestStatus,Long> {
}
