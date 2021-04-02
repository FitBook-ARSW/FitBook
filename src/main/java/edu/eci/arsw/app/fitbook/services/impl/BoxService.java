package edu.eci.arsw.app.fitbook.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Box;
import edu.eci.arsw.app.fitbook.persistence.IBoxPersistence;
import edu.eci.arsw.app.fitbook.services.FitBookException;
import edu.eci.arsw.app.fitbook.services.IBoxServices;

@Service
public class BoxService implements IBoxServices {
    
    @Autowired
    IBoxPersistence bp;

    @Override
    public void addBox(Box box) throws FitBookException {
        try {
            bp.addBox(box);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
        
    }

    @Override
    public Box getUserById(int id) throws FitBookException {
        try {
            return bp.getBoxById(id);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
    }

    @Override
    public List<Box> getAll() throws FitBookException {
        try {
            return bp.getAll();
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
    }


}
