package edu.eci.arsw.app.fitbook.services.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.arsw.app.fitbook.model.Publication;
import edu.eci.arsw.app.fitbook.persistence.IPublicationPersistence;
import edu.eci.arsw.app.fitbook.persistence.cache.IFitbookCache;
import edu.eci.arsw.app.fitbook.services.FitBookException;
import edu.eci.arsw.app.fitbook.services.IPublicationServices;

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
            fc.put(publication);
            /* pp.addPublication(publication); */
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
}
