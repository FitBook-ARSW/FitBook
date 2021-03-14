package edu.eci.arsw.app.fitbook.persistence;

import edu.eci.arsw.app.fitbook.model.User;

public interface IUserPersistence {
    void addUser(User user) throws FitBookPersistenceException;
    User getUserByCedula(String cedula) throws FitBookPersistenceException;
    User getUserByEmail(String email) throws FitBookPersistenceException;
}
