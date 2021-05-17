package edu.eci.arsw.app.fitbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.app.fitbook.model.Class;
import edu.eci.arsw.app.fitbook.services.IClassServices;

@RestController
@CrossOrigin(origins = "*")
public class ClassAPIController {
    
    @Autowired
    IClassServices cs;

    @RequestMapping(path = "/class/add", method = RequestMethod.POST)
    public ResponseEntity<?> createClass(@RequestBody Class clase){
        try {
            cs.addClass(clase);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
