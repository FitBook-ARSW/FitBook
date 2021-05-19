package edu.eci.arsw.app.fitbook.persistence;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Class;

public interface IClassPersistence {
    void addClass(Class clase) throws FitBookPersistenceException;
    List<Class> getClassByBoxDocument(String document) throws FitBookPersistenceException;
}
