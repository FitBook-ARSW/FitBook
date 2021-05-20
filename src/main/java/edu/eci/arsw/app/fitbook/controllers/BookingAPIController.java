package edu.eci.arsw.app.fitbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(path = "/booking/cancel", method = RequestMethod.POST)
    public ResponseEntity<?> cancelBooking(@RequestParam(name="cedula") int cc){
        try {
            bks.cancelBooking(cc);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/booking/asistencia/{fecha}", method = RequestMethod.GET)
    public ResponseEntity<?> getAsistencia(@PathVariable(name = "fecha") String fecha){
        try {
            System.out.println(fecha);
            return new ResponseEntity<>(bks.asistencia(fecha), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/booking/confirm", method = RequestMethod.GET)
    public ResponseEntity<?> confirm(@RequestParam(name = "fecha") String fecha, @RequestParam(name = "cedula") int cc){
        try {
            return new ResponseEntity<>(bks.confirm(cc, fecha), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}