package edu.eci.arsw.app.fitbook.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Box;
import edu.eci.arsw.app.fitbook.model.User;
import edu.eci.arsw.app.fitbook.persistence.IBoxPersistence;
import edu.eci.arsw.app.fitbook.persistence.IUserPersistence;
import edu.eci.arsw.app.fitbook.services.FitBookException;
import edu.eci.arsw.app.fitbook.services.IUserServices;

@Service
public class UserService implements IUserServices {

    @Autowired
    IUserPersistence up;

    @Autowired
    IBoxPersistence bp;

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

    @Override
    public void unrollForBoxByEmail(String email) throws FitBookException {
        try {
            up.unrollForBoxByEmail(email);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
    }

    @Override
    public void changeUrlPhotoFromUser(String url, String mail) throws FitBookException {
        try {
            up.changeUrlPhotoFromUser(url, mail);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }

    }

    @Override
    public List<User> getUsersByBoxId(String document) throws FitBookException {
        try {
            Box box = bp.getBoxByDocument(document);
            return up.getUsersByBoxId(box.getId());
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
    }

    @Override
    public void changeActiveStateOfUserToFalse(String cedula) throws FitBookException {
        try {
            up.changeActiveStateOfUserToFalse(cedula);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
        
    }

    @Override
    public void changeActiveStateOfUserToTrue(String cedula) throws FitBookException {
        try {
            up.changeActiveStateOfUserToTrue(cedula);
        } catch (Exception e) {
            throw new FitBookException(e.toString());
        }
        
    }

}
