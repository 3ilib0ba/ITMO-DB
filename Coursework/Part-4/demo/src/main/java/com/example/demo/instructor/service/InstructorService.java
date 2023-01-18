package com.example.demo.instructor.service;

import com.example.demo.instructor.exceptions.CreatingInstructorException;
import com.example.demo.instructor.exceptions.InstructorNotFoundExceptions;
import com.example.demo.instructor.model.Instructor;
import com.example.demo.instructor.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor getInstructorById(Long id)
            throws InstructorNotFoundExceptions {
        Instructor result = instructorRepository.getInstructorById(id);
        if (result == null)
            throw new InstructorNotFoundExceptions();

        return result;
    }

    public Instructor addInstructor(
            String name,
            String mail,
            String phone,
            String gender
    ) throws CreatingInstructorException {
        Instructor instructor = new Instructor(instructorRepository.count() + 1, name, mail, phone, gender);
        try {
            return instructorRepository.save(instructor);
        } catch (IllegalArgumentException ex) {
            throw new CreatingInstructorException();
        }
    }




}
