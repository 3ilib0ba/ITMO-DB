package com.example.demo.client.controller;

import com.example.demo.client.exceptions.*;
import com.example.demo.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("client/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{clientId}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getUserInfo(
            @PathVariable Long clientId
    ) {
        System.out.println("/client/" + clientId);
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("Client:", clientService.getClient(clientId).toString());
        } catch (ClientNotFoundException ex) {
            model.put("message", "CLIENT_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> addUser(
            @RequestParam("name") String name,
            @RequestParam("mail") String mail,
            @RequestParam("phone") String phone,
            @RequestParam("gender") String gender
    ) {
        System.out.println("/client/add");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", clientService.addUser(name, mail, phone, gender));
        } catch (MailNotFoundException ex) {
            model.put("message", "MAIL_MUST_BE_CORRECT");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } catch (MailIsAlreadyExistException ex) {
            model.put("message", "THIS_MAIL_IS_USED_BY_ANOTHER_USER");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } catch (PhoneNotFoundException ex) {
            model.put("message", "PHONE_MUST_BE_CORRECT");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } catch (PhoneIsAlreadyExistException ex) {
            model.put("message", "THIS_PHONE_IS_USED_BY_ANOTHER_USER");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/get_all", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getAllUsers() {
        System.out.println("/client/get_all");
        Map<Object, Object> model = new HashMap<>();

        model.put("Client:", Arrays.toString(clientService.getAllClients().toArray()));

        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
