package edu.eci.arsw.app.fitbook.persistence;

import edu.eci.arsw.app.fitbook.model.Class;

public interface IClassPersistence {
    void addClass(Class clase) throws FitBookPersistenceException;
}
