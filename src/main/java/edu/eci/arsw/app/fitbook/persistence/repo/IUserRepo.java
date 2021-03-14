package edu.eci.arsw.app.fitbook.persistence.repo;

import edu.eci.arsw.app.fitbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    
}
