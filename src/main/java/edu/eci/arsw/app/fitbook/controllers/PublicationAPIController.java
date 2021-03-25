package edu.eci.arsw.app.fitbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.app.fitbook.model.Publication;
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

    @RequestMapping(path = "/publications/add", method= RequestMethod.POST)
    public ResponseEntity<?> createNewPublication(@RequestBody Publication publication){
        try {
            System.out.println("Publication content "+publication.getContent()+ " " + publication.getLikes()+ " " + publication.getUserId()+ " "+ publication.getId());
            ps.addPublication(publication);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(path = "/publications/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPubicationById(@PathVariable(name = "id") int id){
        try {
            return new ResponseEntity<>(ps.getPublicationById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/publications/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPublicationByUserId(@PathVariable(name = "id") int id){
        try {
            return new ResponseEntity<>(ps.getPublicationsForUserId(id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }
}
