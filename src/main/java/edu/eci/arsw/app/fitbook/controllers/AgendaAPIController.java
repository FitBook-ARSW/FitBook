package edu.eci.arsw.app.fitbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.app.fitbook.model.Agenda;
import edu.eci.arsw.app.fitbook.services.IAgendaServices;

@RestController
@CrossOrigin(origins = "*")
public class AgendaAPIController {
    
    @Autowired
    IAgendaServices as;

    @RequestMapping(path = "/agendar/add", method = RequestMethod.POST)
    public ResponseEntity<?> createAgenda(@RequestBody Agenda agenda){
        try {
            as.addAgenda(agenda);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
