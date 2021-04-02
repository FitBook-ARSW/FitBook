package edu.eci.arsw.app.fitbook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.User;
import edu.eci.arsw.app.fitbook.persistence.IUserPersistence;
import edu.eci.arsw.app.fitbook.services.FitBookException;
import edu.eci.arsw.app.fitbook.services.IUserServices;

@Service
public class UserService implements IUserServices{

    @Autowired
    IUserPersistence up;

    @Override
    public void addUser(User user) throws FitBookException {
        try {
            up.addUser(user);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
    }

    @Override
    public User getUserByCedula(String cedula) throws FitBookException {
        try {
            return up.getUserByCedula(cedula);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
        
    }

    @Override
    public User getUserByEmail(String email) throws FitBookException {
        try {
            return up.getUserByEmail(email);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
    }

    @Override
    public void changeBoxIdFromUser(int boxId, String mail) throws FitBookException {
        try {
            up.changeBoxIdFromUser(boxId, mail);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }        
    }
    
}
