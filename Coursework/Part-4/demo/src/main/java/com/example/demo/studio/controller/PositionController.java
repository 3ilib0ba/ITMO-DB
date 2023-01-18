package com.example.demo.studio.controller;

import com.example.demo.studio.exceptions.PositionNotFoundException;
import com.example.demo.studio.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("position/")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping(value = "/byAddress", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getPositionByAddress(
            @RequestParam(name = "address") String address
    ) {
        System.out.println("/position/byAddress");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", positionService.getPositionByAddress(address).toString());
        } catch (PositionNotFoundException ex) {
            model.put("message", "POSITION_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/byId", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getPositionById(
            @RequestParam(name = "id") Long id
    ) {
        System.out.println("/position/byAddress");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", positionService.getPositionById(id).toString());
        } catch (PositionNotFoundException ex) {
            model.put("message", "POSITION_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/allByStudio", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getPositionsByStudioId(
            @RequestParam(name = "studioId") Long studioId
    ) {
        System.out.println("/position/allByStudio");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", Arrays.toString(positionService.getAllPositionByStudioId(studioId).toArray()));
        } catch (PositionNotFoundException ex) {
            model.put("message", "POSITIONS_WITH_THIS_STUDIO_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
