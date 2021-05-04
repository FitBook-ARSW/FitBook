package edu.eci.arsw.app.fitbook.persistence;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.User;

public interface IUserPersistence {
    void addUser(User user) throws FitBookPersistenceException;
    User getUserByCedula(String cedula) throws FitBookPersistenceException;
    User getUserByEmail(String email) throws FitBookPersistenceException;
    void changeBoxIdFromUser(int boxId, String mail) throws FitBookPersistenceException;
    void unrollForBoxByEmail(String email) throws FitBookPersistenceException;
    void changeUrlPhotoFromUser(String url, String mail) throws FitBookPersistenceException;
    List<User> getUsersByBoxId(int boxId) throws FitBookPersistenceException;
    void changeActiveStateOfUserToFalse(String cedula) throws FitBookPersistenceException;
    void changeActiveStateOfUserToTrue(String cedula) throws FitBookPersistenceException;
}
