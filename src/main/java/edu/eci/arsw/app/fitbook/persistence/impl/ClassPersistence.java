package edu.eci.arsw.app.fitbook.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Class;
import edu.eci.arsw.app.fitbook.persistence.FitBookPersistenceException;
import edu.eci.arsw.app.fitbook.persistence.IClassPersistence;
import edu.eci.arsw.app.fitbook.persistence.repo.IClassRepo;

@Service
public class ClassPersistence implements IClassPersistence{

    @Autowired
    IClassRepo cr;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addClass(Class clase) throws FitBookPersistenceException {
        try {
            cr.save(clase);
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error to save a new class");
        }        
    }

    @Override
    public List<Class> getClassByBoxDocument(String document) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from clase where document=?", Class.class);
            query.setParameter(1, document);
            if (query.getResultList().size() == 0) {
                throw new FitBookPersistenceException("Error to load classes for this box id");
            }
            return query.getResultList();
        } catch (Exception e) {
            throw new FitBookPersistenceException(e.toString());
        }
    }
    
}
