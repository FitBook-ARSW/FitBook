package edu.eci.arsw.app.fitbook.persistence;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Like;
import edu.eci.arsw.app.fitbook.model.Publication;

public interface IPublicationPersistence {
    public void addPublication(Publication publication) throws FitBookPersistenceException;
    public Publication getPublicationById(int publication_id) throws FitBookPersistenceException;
    public void removeLike(int idl) throws FitBookPersistenceException;
    List<Like> getLikesByPost2(int postid) throws FitBookPersistenceException;
    int getLikesByPost(int postid) throws FitBookPersistenceException;
    List<Like> getAllLikes() throws FitBookPersistenceException;
    List<Publication> getAllPublications() throws FitBookPersistenceException;
    List<Publication> getPublicationsForUserId(int user_id) throws FitBookPersistenceException;
    public void deletePublicationById(int publication_id) throws FitBookPersistenceException;
    public void addLike(Like like) throws FitBookPersistenceException;
}
