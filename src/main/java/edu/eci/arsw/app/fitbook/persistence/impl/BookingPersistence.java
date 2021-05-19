package edu.eci.arsw.app.fitbook.persistence.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Booking;
import edu.eci.arsw.app.fitbook.persistence.IBookingPersistence;
import edu.eci.arsw.app.fitbook.persistence.repo.IBookingRepo;

@Service
public class BookingPersistence implements IBookingPersistence{
    
    @Autowired
    IBookingRepo bk;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void booking(Booking booking) {
        try {
            bk.save(booking);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
