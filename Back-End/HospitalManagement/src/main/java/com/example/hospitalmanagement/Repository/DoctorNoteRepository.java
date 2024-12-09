package com.example.hospitalmanagement.Repository;

import com.example.hospitalmanagement.Entity.DoctorNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorNoteRepository extends JpaRepository<DoctorNote,Long> {
}
