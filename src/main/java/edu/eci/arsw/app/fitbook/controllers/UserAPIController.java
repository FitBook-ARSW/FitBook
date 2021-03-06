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

import edu.eci.arsw.app.fitbook.model.User;
import edu.eci.arsw.app.fitbook.services.IUserServices;

@RestController
@CrossOrigin(origins = "*")
public class UserAPIController {
    
    @Autowired
    IUserServices us;


    @RequestMapping(path = "/users/newUser", method = RequestMethod.POST)
    public ResponseEntity<?> createNewUser(@RequestBody User user){
        try {
            us.addUser(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/users/cc/{cedula}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByCC(@PathVariable(name = "cedula") String cedula){
        try {
            return new ResponseEntity<>(us.getUserByCedula(cedula),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/users/email/{correo}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByEmail(@PathVariable(name= "correo") String correo){
        try {
            System.out.println("Entre a email");
            return new ResponseEntity<>(us.getUserByEmail(correo) ,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }
}
