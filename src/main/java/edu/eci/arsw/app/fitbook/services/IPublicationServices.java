package edu.eci.arsw.app.fitbook.services;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Publication;

public interface IPublicationServices {
    List<Publication> getAllPublications() throws FitBookException;
    void addPublication(Publication publication) throws FitBookException;
    Publication getPublicationById(int publication_id) throws FitBookException;
    List<Publication> getPublicationsForUserId(int user_id) throws FitBookException;
    void deletePublicationById(int publication_id) throws FitBookException;
}
