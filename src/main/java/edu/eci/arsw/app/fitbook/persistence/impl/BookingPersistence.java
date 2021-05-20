package edu.eci.arsw.app.fitbook.persistence.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

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

    @Override
    @Transactional
    public void cancelBooking(int cc) {
        try {
            Query query = entityManager.createNativeQuery("delete from reservas where iduser=?");
            query.setParameter(1, cc);
            query.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public BigInteger asistencia(String fecha) throws Exception {
        try {
            Query query = entityManager.createNativeQuery("select count(*) from reservas where fecha=?");
            query.setParameter(1, fecha);
            System.out.println(query.getSingleResult());
            return (BigInteger)query.getSingleResult();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
