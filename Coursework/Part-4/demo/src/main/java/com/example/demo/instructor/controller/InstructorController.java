package com.example.demo.instructor.controller;

import com.example.demo.instructor.exceptions.CreatingInstructorException;
import com.example.demo.instructor.exceptions.InstructorNotFoundExceptions;
import com.example.demo.instructor.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping(value = "/byId", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getInstructorById(
            @RequestParam(name = "id") Long id
    ) {
        System.out.println("/instructor/byId");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", instructorService.getInstructorById(id).toString());
        } catch (InstructorNotFoundExceptions ex) {
            model.put("message", "INSTRUCTOR_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> addNewInstructor(
            @RequestParam("name") String name,
            @RequestParam("mail") String mail,
            @RequestParam("phone") String phone,
            @RequestParam("gender") String gender
    ) {
        System.out.println("/instructor/add");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", instructorService.addInstructor(
                    name, mail, phone, gender).toString());
        }  catch (CreatingInstructorException ex) {
            model.put("message", "ERROR_WITH_CREATING_THIS_ENTITY");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
