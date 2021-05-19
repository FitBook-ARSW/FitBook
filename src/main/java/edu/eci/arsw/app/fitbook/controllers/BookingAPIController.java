package edu.eci.arsw.app.fitbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.app.fitbook.model.Booking;
import edu.eci.arsw.app.fitbook.services.IBookingServices;

@RestController
@CrossOrigin(origins = "*")
public class BookingAPIController {
    
    @Autowired
    IBookingServices bks;

    @RequestMapping(path = "/booking/add", method = RequestMethod.POST)
    public ResponseEntity<?> createNewBox(@RequestBody Booking booking){
        try {
            bks.booking(booking);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}