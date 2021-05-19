package edu.eci.arsw.app.fitbook.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eci.arsw.app.fitbook.model.Booking;

public interface IBookingRepo extends JpaRepository<Booking, Integer>{
}
