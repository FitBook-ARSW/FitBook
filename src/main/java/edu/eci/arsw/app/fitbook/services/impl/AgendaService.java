package edu.eci.arsw.app.fitbook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Agenda;
import edu.eci.arsw.app.fitbook.persistence.IAgendaPersistence;
import edu.eci.arsw.app.fitbook.services.FitBookException;
import edu.eci.arsw.app.fitbook.services.IAgendaServices;

@Service
public class AgendaService implements IAgendaServices{

    @Autowired
    IAgendaPersistence ap;

    @Override
    public void addAgenda(Agenda agenda) throws FitBookException {
        try {
            ap.addAgenda(agenda);
        } catch (Exception e) {
            throw new FitBookException("Error to add agenda");
        }        
    }
    
}
