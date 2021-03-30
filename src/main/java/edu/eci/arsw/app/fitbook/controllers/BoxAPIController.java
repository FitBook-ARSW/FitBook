package edu.eci.arsw.app.fitbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.app.fitbook.model.Box;
import edu.eci.arsw.app.fitbook.services.IBoxServices;

@RestController
@CrossOrigin(origins = "*")
public class BoxAPIController {
    
    @Autowired
    IBoxServices bs;

    @RequestMapping(path = "box/add", method = RequestMethod.POST)
    public ResponseEntity<?> createNewBox(@RequestBody Box box){
        try {
            bs.addBox(box);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "box/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBoxById(@PathVariable(name = "id") int id){
        try {
            return new ResponseEntity<>(bs.getUserById(id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }
}
