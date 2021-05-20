package edu.eci.arsw.app.fitbook.persistence;

import java.math.BigInteger;

import edu.eci.arsw.app.fitbook.model.Booking;

public interface IBookingPersistence {
    void booking(Booking booking);
    void cancelBooking(int cc);
    BigInteger asistencia(String fecha) throws Exception;
}
