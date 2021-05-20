package edu.eci.arsw.app.fitbook.services.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.Booking;
import edu.eci.arsw.app.fitbook.persistence.IBookingPersistence;
import edu.eci.arsw.app.fitbook.services.IBookingServices;

@Service
public class BookingService implements IBookingServices{
    
    @Autowired
    IBookingPersistence bk;

    @Override
    public void booking(Booking booking) {
        try {
            bk.booking(booking);
        } catch (Exception e) {
           e.getMessage();
        }
        
    }

    @Override
    public void cancelBooking(int cc) {
        try {
            bk.cancelBooking(cc);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public BigInteger asistencia(String fecha) throws Exception {
        try {
            BigInteger entero = bk.asistencia(fecha);
            return entero;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public BigInteger confirm(int cc, String fecha) throws Exception {
        try {
            BigInteger entero = bk.confirm(cc, fecha);
            return entero;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e.getMessage());
        }
    }

}
