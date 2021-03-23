package edu.eci.arsw.app.fitbook.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Publication;
import edu.eci.arsw.app.fitbook.persistence.FitBookPersistenceException;
import edu.eci.arsw.app.fitbook.persistence.IPublicationPersistence;
import edu.eci.arsw.app.fitbook.persistence.repo.IPublicationsRepo;

@Service
public class PublicationPersistence implements IPublicationPersistence{

    @Autowired
    IPublicationsRepo pr;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Publication> getAllPublications() throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from publications order by uploaddate desc", Publication.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new FitBookPersistenceException("Publications not founds");
        }
    }
    
}
