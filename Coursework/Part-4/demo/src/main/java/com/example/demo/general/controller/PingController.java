package com.example.demo.general.controller;

import com.example.demo.general.model.Ping;
import com.example.demo.general.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("gen")
public class PingController {

    @Autowired
    private PingService pingService;

    @Value("${spring.application.name}")
    private String name;

    @Value("${spring.application.author_name}")
    private String name_author;


    @GetMapping(value = "/", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getApplicationName() {
        System.out.println("request /gen");
        Map<Object, Object> model = new HashMap<>();

        model.put("name of application:", name);
        model.put("author:", name_author);

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/ping", produces = "application/json;charset=UTF-8")
    public String makePing() {
        System.out.println("request /gen/ping");

        pingService.addNewPingFromNow();

        return "Server is working correctly";
    }

    @GetMapping(value = "/get_pings", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getAllPings() {
        System.out.println("request /gen/get_pings");
        Map<Object, Object> model = new HashMap<>();

        List<Ping> pings = pingService.getAllPings();
        model.put("pings:", Arrays.toString(pings.toArray()));

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
