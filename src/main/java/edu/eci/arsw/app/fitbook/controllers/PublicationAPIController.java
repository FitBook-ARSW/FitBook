package edu.eci.arsw.app.fitbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.app.fitbook.services.IPublicationServices;

@RestController
@CrossOrigin(origins = "*")
public class PublicationAPIController {
    
    @Autowired
    IPublicationServices ps;

    @RequestMapping(path = "/publications", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPost(){
        try {
            return new ResponseEntity<>(ps.getAllPublications(),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    } 
}
