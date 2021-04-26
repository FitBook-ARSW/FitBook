package edu.eci.arsw.app.fitbook.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Like;
import edu.eci.arsw.app.fitbook.model.Publication;
import edu.eci.arsw.app.fitbook.persistence.FitBookPersistenceException;
import edu.eci.arsw.app.fitbook.persistence.IPublicationPersistence;
import edu.eci.arsw.app.fitbook.persistence.repo.ILikeRepo;
import edu.eci.arsw.app.fitbook.persistence.repo.IPublicationsRepo;

@Service
public class PublicationPersistence implements IPublicationPersistence{

    @Autowired
    IPublicationsRepo pr;

    @Autowired
    ILikeRepo lr;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Publication> getAllPublications() throws FitBookPersistenceException {
        try {
            System.out.println("Message to database");
            Query query = entityManager.createNativeQuery("select * from publications order by uploaddate desc", Publication.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new FitBookPersistenceException("Publications not founds");
        }
    }

    @Override
    public void addPublication(Publication publication) throws FitBookPersistenceException {
        try {
            System.out.println("Entre add");
            pr.save(publication);            
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error to create publication");
        }
    }

    @Override
    public Publication getPublicationById(int publication_id) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from publications where publication_id=?", Publication.class);
            query.setParameter(1, publication_id);
            if (query.getResultList().size() == 0) {
                throw new FitBookPersistenceException("Publication not found");
            }
            System.out.println("Query to DataBase");
            return (Publication) query.getSingleResult();
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error no find Publication");
        }
    }

    @Override
    public List<Publication> getPublicationsForUserId(int user_id) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from publications where user_id=?", Publication.class);
            query.setParameter(1, user_id);
            if (query.getResultList().size() == 0) {
                throw new FitBookPersistenceException("Publication not found");
            }
            return query.getResultList();
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error no find Publication");
        }
    }

    @Override
    public void deletePublicationById(int publication_id) throws FitBookPersistenceException {
        try {
            pr.deleteById(publication_id);
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error to delete publications");
        } 
    }
           
    public int getLikesByPost(int postid) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from likes where postid=?", Like.class);
            query.setParameter(1, postid);
            System.out.println(query.getSingleResult());
            return query.getResultList().size();
        } catch (Exception e) {
            throw new FitBookPersistenceException(e.getMessage());
        }
    }

    @Override
    public void addLike(Like like) throws FitBookPersistenceException {
        try {
            System.out.println("Entre add");
            lr.save(like);
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error to create publication");
        }
    }
}
