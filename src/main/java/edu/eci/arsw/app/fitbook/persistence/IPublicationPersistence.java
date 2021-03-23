package edu.eci.arsw.app.fitbook.persistence;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Publication;

public interface IPublicationPersistence {
    List<Publication> getAllPublications() throws FitBookPersistenceException;
}
