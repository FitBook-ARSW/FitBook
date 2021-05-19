package edu.eci.arsw.app.fitbook.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Agenda;
import edu.eci.arsw.app.fitbook.persistence.FitBookPersistenceException;
import edu.eci.arsw.app.fitbook.persistence.IAgendaPersistence;
import edu.eci.arsw.app.fitbook.persistence.repo.IAgendaRepo;

@Service
public class AgendaPersistence implements IAgendaPersistence{

    @Autowired
    IAgendaRepo ar;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addAgenda(Agenda agenda) throws FitBookPersistenceException {
        try {
            ar.save(agenda);
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error to save a new class");
        }
    }

    @Override
    public List<Agenda> getAgendaForClient(String document) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from agenda where document=?", Agenda.class);
            query.setParameter(1, document);
            return query.getResultList();
        } catch (Exception e) {
            throw new FitBookPersistenceException(e.toString());
        }
    }

    
}
