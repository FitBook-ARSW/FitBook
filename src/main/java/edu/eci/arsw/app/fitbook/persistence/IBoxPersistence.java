package edu.eci.arsw.app.fitbook.persistence;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Box;

public interface IBoxPersistence {
    void addBox(Box box) throws FitBookPersistenceException;
    Box getBoxById(int id) throws FitBookPersistenceException;
    List<Box> getAll() throws FitBookPersistenceException;
    Box getBoxByDocument(String document) throws FitBookPersistenceException;
}
