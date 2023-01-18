package com.example.demo.classes.controller;

import com.example.demo.classes.exceptions.ClassesNotFoundException;
import com.example.demo.classes.service.ClassesService;
import com.example.demo.studio.exceptions.PositionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @GetMapping(value = "/byId", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getClassById(
            @RequestParam(name = "id") Long id
    ) {
        System.out.println("/classes/byId");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", classesService.getClassById(id).toString());
        } catch (ClassesNotFoundException ex) {
            model.put("message", "CLASS_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> addNewClass(
            @RequestParam("name") String name,
            // date format from string yyyy-[m]m-[d]d
            @RequestParam("date") String date,
            // time format from string hh:mm:ss
            @RequestParam("start") String start,
            @RequestParam("end") String end,
            @RequestParam("amount") Float amount,
            @RequestParam("posId") Long posId
    ) {
        System.out.println("/classes/add");
        Map<Object, Object> model = new HashMap<>();

        try {
            Date dateOf = Date.valueOf(date);
            Time start_time = Time.valueOf(start);
            Time end_time = Time.valueOf(end);

            model.put("message", classesService.addClass(
                    name, dateOf, start_time, end_time, amount, posId).toString());
        } catch (IllegalArgumentException ex) {
            model.put("message", "INCORRECT_ARGUMENTS_OF_DATE_OR_TIMES");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } catch (PositionNotFoundException ex) {
            model.put("message", "POSITION_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
