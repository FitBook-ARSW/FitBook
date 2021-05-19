package edu.eci.arsw.app.fitbook.services;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Class;

public interface IClassServices {
    void addClass(Class clase) throws FitBookException;
    List<Class> getClassByBoxDocument(String document) throws FitBookException;
}
