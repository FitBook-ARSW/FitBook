package edu.eci.arsw.app.fitbook.services.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.arsw.app.fitbook.model.Like;
import edu.eci.arsw.app.fitbook.model.Publication;
import edu.eci.arsw.app.fitbook.persistence.IPublicationPersistence;
import edu.eci.arsw.app.fitbook.persistence.cache.IFitbookCache;
import edu.eci.arsw.app.fitbook.services.FitBookException;
import edu.eci.arsw.app.fitbook.services.IPublicationServices;
import org.springframework.scheduling.annotation.Scheduled;

@Service
public class PublicationService implements IPublicationServices {

    @Autowired
    IPublicationPersistence pp;

    @Autowired
    IFitbookCache fc;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Publication> getAllPublications() throws FitBookException {
        try {
            return fc.getAll();
            /* return pp.getAllPublications(); */
        } catch (Exception e) {
            throw new FitBookException("Publications not found");
        }
    }

    @Override
    public void addPublication(Publication publication) throws FitBookException {
        try {
            /* fc.put(publication); */
            pp.addPublication(publication);
        } catch (Exception e) {
            throw new FitBookException("Error to add publication");
        }
        
    }

    @Override
    public Publication getPublicationById(int publication_id) throws FitBookException {
        try {
            return fc.get(publication_id);
            /* return pp.getPublicationById(publication_id); */
        } catch (Exception e) {
            throw new FitBookException("Publication not found");
        }
    }

    @Override
    public List<Publication> getPublicationsForUserId(int user_id) throws FitBookException {
        try {
            return pp.getPublicationsForUserId(user_id);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
    }

    @Override
    public void deletePublicationById(int publication_id) throws FitBookException {
        try {
            pp.deletePublicationById(publication_id);
        } catch (Exception e) {
            throw new FitBookException("Error to delete Post");
        }
        
    }

    @Override
    public int getLikesByPost(int postid) throws FitBookException {
        try {
            return pp.getLikesByPost(postid);
        } catch (Exception e) {
            System.out.println(postid);
            throw new FitBookException(e.getMessage());
        }
    }
    @Override
    public List<Like> getLikesByPost2(int postid) throws FitBookException {
        try {
            return pp.getLikesByPost2(postid);
        } catch (Exception e) {
            System.out.println(postid);
            throw new FitBookException(e.getMessage());
        }
    }

    @Override
    public void addLike(Like like) throws FitBookException {
        try {
            pp.addLike(like);
        } catch (Exception e) {
            throw new FitBookException("Error to delete Post");
        }
    }

    @Scheduled(fixedDelay = 60000)
    public void reseltHashOperation() throws Exception {
        List<Publication> oldPublications = fc.getAll();
        for(int i = 0; i < oldPublications.size(); i++){
            fc.delete(oldPublications.get(i).publication_id);
        }
        List<Publication> newPublications = pp.getAllPublications();
        for(int i = 0; i<newPublications.size(); i++){
            fc.put(newPublications.get(i));
        }
    }

    @Override
    public List<Like> getAllLikes() throws FitBookException {
        try {
            return pp.getAllLikes();
        } catch (Exception e) {
            throw new FitBookException(e.getMessage());
        }
    }

    @Override
    public void removeLike(int idl) throws FitBookException {
        try {
            pp.removeLike(idl);
        } catch (Exception e) {
            throw new FitBookException("Error to delete Like");
        }        
    }
}
