package edu.eci.arsw.app.fitbook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Class;
import edu.eci.arsw.app.fitbook.persistence.IClassPersistence;
import edu.eci.arsw.app.fitbook.services.FitBookException;
import edu.eci.arsw.app.fitbook.services.IClassServices;

@Service
public class ClassServices implements IClassServices{
    @Autowired
    IClassPersistence cp;

    @Override
    public void addClass(Class clase) throws FitBookException{
        try {
            cp.addClass(clase);
        } catch (Exception e) {
            throw new FitBookException("Error to create class");
        }        
    }
    
}
