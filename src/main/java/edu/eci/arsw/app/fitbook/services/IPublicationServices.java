package edu.eci.arsw.app.fitbook.services;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Publication;

public interface IPublicationServices {
    List<Publication> getAllPublications() throws FitBookException;
}
