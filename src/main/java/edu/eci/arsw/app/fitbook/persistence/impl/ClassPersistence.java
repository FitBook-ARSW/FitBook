package edu.eci.arsw.app.fitbook.persistence.impl;

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

    @Override
    public void addClass(Class clase) throws FitBookPersistenceException {
        try {
            cr.save(clase);
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error to save a new class");
        }        
    }
    
}
