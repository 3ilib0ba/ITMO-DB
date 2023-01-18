package com.example.demo.instructor.repository;

import com.example.demo.instructor.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    public Instructor getInstructorById(Long id);

}
