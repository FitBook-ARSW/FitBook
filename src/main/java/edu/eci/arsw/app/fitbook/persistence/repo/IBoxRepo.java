package edu.eci.arsw.app.fitbook.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eci.arsw.app.fitbook.model.Box;

public interface IBoxRepo extends JpaRepository<Box,Integer>{
    
}
