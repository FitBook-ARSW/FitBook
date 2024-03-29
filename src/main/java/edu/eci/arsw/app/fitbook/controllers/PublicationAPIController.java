package edu.eci.arsw.app.fitbook.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.app.fitbook.model.Like;
import edu.eci.arsw.app.fitbook.model.Publication;
import edu.eci.arsw.app.fitbook.services.IPublicationServices;
import edu.eci.arsw.app.fitbook.services.IUserServices;

@RestController
@CrossOrigin(origins = "*")
public class PublicationAPIController {

    @Autowired
    IUserServices us;

    @Autowired
    IPublicationServices ps;

    @RequestMapping(path = "/publications", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPost() {
        try {
            return new ResponseEntity<>(ps.getAllPublications(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/likes", method = RequestMethod.GET)
    public ResponseEntity<?> getAllLikes() {
        try {
            return new ResponseEntity<>(ps.getAllLikes(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/publications/add", method = RequestMethod.POST)
    public ResponseEntity<?> createNewPublication(@RequestBody Publication publication) {
        try {
            int index = ps.getAllPublications().size();
            publication.setId(index + 1);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            publication.setUploadDate(formatter.format(date));
            ps.addPublication(publication);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/likes/add", method = RequestMethod.POST)
    public ResponseEntity<?> addLike(@RequestBody Like like) {
        try {
            int index = ps.getAllLikes().size();
            like.setLike_id(index+1);
            ps.addLike(like);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/likes/remove/{like_id}", method = RequestMethod.POST)
    public ResponseEntity<?> removeLike(@PathVariable(name = "like_id") int idl) {
        try {
            ps.removeLike(idl);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/publications/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPubicationById(@PathVariable(name = "id") int id) {
        try {
            return new ResponseEntity<>(ps.getPublicationById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/publications/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPublicationByUserId(@PathVariable(name = "id") int id) {
        try {
            return new ResponseEntity<>(ps.getPublicationsForUserId(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/publications/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> deletePublicationById(@PathVariable(name = "id") int publication_id) {
        try {
            ps.deletePublicationById(publication_id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/likes/{postid}", method = RequestMethod.GET)
    public ResponseEntity<?> getLikesByPost(@PathVariable(name = "postid") int postid) {
        try {
            return new ResponseEntity<>(ps.getLikesByPost(postid), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/likes/post/{postid}", method = RequestMethod.GET)
    public ResponseEntity<?> getLikesByPost2(@PathVariable(name = "postid") int postid) {
        try {
            return new ResponseEntity<>(ps.getLikesByPost2(postid), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
