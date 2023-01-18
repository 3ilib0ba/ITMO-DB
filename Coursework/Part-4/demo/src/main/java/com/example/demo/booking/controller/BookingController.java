package com.example.demo.booking.controller;

import com.example.demo.booking.exceptions.BookingNotFoundException;
import com.example.demo.booking.exceptions.NotEnoughMoneyToBookException;
import com.example.demo.booking.service.BookingService;
import com.example.demo.classes.exceptions.ClassesNotFoundException;
import com.example.demo.client.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "/byId", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getBookingById(
            @RequestParam(name = "id") Long id
    ) {
        System.out.println("/booking/byId");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", bookingService.getBookingById(id).toString());
        } catch (BookingNotFoundException ex) {
            model.put("message", "BOOKING_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> addNewBooking(
            @RequestParam("clientId") Long clientId,
            @RequestParam("classId") Long classId
    ) {
        System.out.println("/booking/add");
        Map<Object, Object> model = new HashMap<>();

        try {
            model.put("message", bookingService.addBooking(
                    clientId, classId).toString());
        }  catch (ClientNotFoundException ex) {
            model.put("message", "CLIENT_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } catch (ClassesNotFoundException ex) {
            model.put("message", "CLASS_NOT_FOUND");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        } catch (NotEnoughMoneyToBookException ex) {
            model.put("message", "NOT_ENOUGH_MONEY");
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
