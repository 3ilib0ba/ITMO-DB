package com.example.demo.studio.controller;

import com.example.demo.studio.exceptions.StudioNotFoundException;
import com.example.demo.studio.service.LegalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("legal/")
public class LegalInfoController {
    @Autowired
    private LegalInfoService legalInfoService;


    @GetMapping(value = "/byName", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getLegalInfo(
            @RequestParam(name = "name") String studioName
    ) {
        System.out.println("/legal/byName");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", legalInfoService.getInfoByStudioName(studioName).toString());
        } catch (StudioNotFoundException ex) {
            model.put("message", "STUDIO_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
