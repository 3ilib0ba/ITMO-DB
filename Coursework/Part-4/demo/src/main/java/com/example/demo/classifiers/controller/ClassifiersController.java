package com.example.demo.classifiers.controller;

import com.example.demo.classifiers.exceptions.ClassifierNotFoundException;
import com.example.demo.classifiers.service.ClassifiersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/classifiers")
public class ClassifiersController {
    @Autowired
    private ClassifiersService classifiersService;

    @GetMapping(value = "/byId", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getClassifierById(
            @RequestParam(name = "id") Long id
    ) {
        System.out.println("/classifiers/byId");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", classifiersService.getClassifierById(id).toString());
        } catch (ClassifierNotFoundException ex) {
            model.put("message", "CLASSIFIER_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/byNameAndValue", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getClassifierByNameAndValue(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "value") String value
    ) {
        System.out.println("/classifiers/byNameAndValue");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", classifiersService.getClassifierByNameAndValue(name, value).toString());
        } catch (ClassifierNotFoundException ex) {
            model.put("message", "CLASSIFIER_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/getAll", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getAllClassifiers() {
        System.out.println("/classifiers/getAll");
        Map<Object, Object> model = new HashMap<>();

        model.put("message", classifiersService.getAllClassifiers().toString());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> addNewClassifier(
            @RequestParam("name") String name,
            @RequestParam("value") String value
    ) {
        System.out.println("/classifiers/add");
        Map<Object, Object> model = new HashMap<>();

        model.put("message", classifiersService.addNewClassifier(name, value).toString());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }


}
