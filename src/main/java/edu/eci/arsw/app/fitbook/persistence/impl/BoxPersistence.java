package edu.eci.arsw.app.fitbook.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Box;
import edu.eci.arsw.app.fitbook.persistence.FitBookPersistenceException;
import edu.eci.arsw.app.fitbook.persistence.IBoxPersistence;
import edu.eci.arsw.app.fitbook.persistence.repo.IBoxRepo;

@Service
public class BoxPersistence implements IBoxPersistence{

    @Autowired
    IBoxRepo br;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addBox(Box box) throws FitBookPersistenceException {
        try {
            br.save(box);
        } catch (Exception e) {
            throw new FitBookPersistenceException("Problem to create new box");
        }
    }

    @Override
    public Box getBoxById(int id) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from box where id=?", Box.class);
            query.setParameter(1, id);
            if (query.getResultList().size() == 0) {
                throw new FitBookPersistenceException("Box not found");
            }
            return (Box) query.getSingleResult();
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error no find Box");
        }
    }

    @Override
    public List<Box> getAll() throws FitBookPersistenceException {
        try {
            System.out.println("Message to database");
            Query query = entityManager.createNativeQuery("select * from box", Box.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new FitBookPersistenceException("Publications not founds");
        }
    }
    
}
