package com.example.demo.studio.controller;

import com.example.demo.client.exceptions.MailIsAlreadyExistException;
import com.example.demo.client.exceptions.MailNotFoundException;
import com.example.demo.studio.exceptions.StudioNotFoundException;
import com.example.demo.studio.exceptions.TinIsAlreadyExistException;
import com.example.demo.studio.exceptions.TinNotFoundException;
import com.example.demo.studio.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("studio/")
public class StudioController {
    @Autowired
    private StudioService studioService;

    @GetMapping(value = "/byName", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getStudio(
            @RequestParam(name = "name") String studioName
    ) {
        System.out.println("/studio/byName");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", studioService.getStudioByName(studioName).toString());
        } catch (StudioNotFoundException ex) {
            model.put("message", "STUDIO_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> addStudioWithLegalInfo(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("fullDescription") String fullDescription,
            @RequestParam("mail") String mail,
            @RequestParam("phone") String phone,
            @RequestParam("TIN") String tin
    ) {
        System.out.println("/studio/add");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", studioService.addStudioAndLegalInfo(
                    name, description,
                    fullDescription, mail, phone, tin
            ).toString());
        } catch (MailNotFoundException ex) {
            model.put("message", "MAIL_MUST_BE_CORRECT");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } catch (MailIsAlreadyExistException ex) {
            model.put("message", "THIS_MAIL_IS_USED_BY_ANOTHER_USER");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } catch (TinNotFoundException ex) {
            model.put("message", "TIN_MUST_BE_CORRECT");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } catch (TinIsAlreadyExistException ex) {
            model.put("message", "THIS_TIN_IS_USED_BY_ANOTHER_USER");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/get_all", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getAllStudios() {
        System.out.println("/studio/get_all");
        Map<Object, Object> model = new HashMap<>();

        model.put("message", Arrays.toString(studioService.getAllStudios().toArray()));

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping(value = "addPosition", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> addPositionToStudioById(
            @RequestParam("studioId") Long studioId,
            @RequestParam("address") String address,
            @RequestParam("hours") String hours
    ) {
        System.out.println("/studio/addPosition");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", studioService.addPositionToStudio(
                    studioId,
                    address,
                    hours
            ).toString());
        } catch (StudioNotFoundException ex) {
            model.put("message", "STUDIO_NOT_FOUND_BY_ID");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
