package edu.eci.arsw.app.fitbook.services;

import java.math.BigInteger;

import edu.eci.arsw.app.fitbook.model.Booking;

public interface IBookingServices {
    void booking(Booking booking);
    void cancelBooking(int cc);
    BigInteger asistencia(String fecha) throws Exception;
}
