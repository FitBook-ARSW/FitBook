package edu.eci.arsw.app.fitbook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.arsw.app.fitbook.model.Class;
import edu.eci.arsw.app.fitbook.persistence.FitBookPersistenceException;
import edu.eci.arsw.app.fitbook.persistence.IClassPersistence;

public class ClassServices implements IClassPersistence{
    @Autowired
    IClassPersistence cp;

    @Override
    public void addClass(Class clase) throws FitBookPersistenceException {
        try {
            cp.addClass(clase);
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error to create class");
        }        
    }
    
}
