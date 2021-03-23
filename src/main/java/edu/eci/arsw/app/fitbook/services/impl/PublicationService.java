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
            return pp.getAllPublications();
        } catch (Exception e) {
            throw new FitBookException("Publications not found");
        }
    }
}
