package edu.eci.arsw.app.fitbook.services;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.User;

public interface IUserServices {
    void addUser(User user) throws FitBookException;
    User getUserByCedula(String cedula) throws FitBookException;
    User getUserByEmail(String email) throws FitBookException;
    void changeBoxIdFromUser(int boxId, String mail) throws FitBookException;
    void unrollForBoxByEmail(String email) throws FitBookException;
    void changeUrlPhotoFromUser(String url, String mail) throws FitBookException;
    List<User> getUsersByBoxId(String document) throws FitBookException;
}
