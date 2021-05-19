package edu.eci.arsw.app.fitbook.persistence;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Agenda;

public interface IAgendaPersistence {
    void addAgenda(Agenda agenda) throws FitBookPersistenceException;
    List<Agenda> getAgendaForClient(String document) throws FitBookPersistenceException;
}
