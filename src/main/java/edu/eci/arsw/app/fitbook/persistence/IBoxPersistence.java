package edu.eci.arsw.app.fitbook.persistence;

import edu.eci.arsw.app.fitbook.model.Box;

public interface IBoxPersistence {
    void addBox(Box box) throws FitBookPersistenceException;
    Box getBoxById(int id) throws FitBookPersistenceException;
}
