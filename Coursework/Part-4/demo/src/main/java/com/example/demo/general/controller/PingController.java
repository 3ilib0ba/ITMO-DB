package com.example.demo.general.controller;

import com.example.demo.general.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PingController {

    @Autowired
    private PingService pingService;

    @Value("${spring.application.name}")
    private String name;

    @Value("${spring.application.author_name}")
    private String name_author;


    @GetMapping(value = "/gen", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getApplicationName() {
        System.out.println("request /");
        Map<Object, Object> model = new HashMap<>();

        model.put("name of application:", name);
        model.put("author:", name_author);

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/gen/ping", produces = "application/json;charset=UTF-8")
    public String getPing() {
        System.out.println("request /ping");

        pingService.addNewPingFromNow();

        return "Server is working correctly";
    }
}
