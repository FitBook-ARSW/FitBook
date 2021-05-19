package edu.eci.arsw.app.fitbook.services.impl;

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

}
