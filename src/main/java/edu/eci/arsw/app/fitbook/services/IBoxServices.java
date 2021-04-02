package edu.eci.arsw.app.fitbook.services;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Box;

public interface IBoxServices {
    void addBox(Box box) throws FitBookException;
    Box getUserById(int id) throws FitBookException;
    List<Box> getAll() throws FitBookException;
}
