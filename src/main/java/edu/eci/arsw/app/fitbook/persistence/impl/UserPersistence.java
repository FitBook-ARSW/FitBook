package edu.eci.arsw.app.fitbook.persistence.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.app.fitbook.model.User;
import edu.eci.arsw.app.fitbook.persistence.FitBookPersistenceException;
import edu.eci.arsw.app.fitbook.persistence.IUserPersistence;
import edu.eci.arsw.app.fitbook.persistence.repo.IUserRepo;

@Service
public class UserPersistence implements IUserPersistence {

    @Autowired
    IUserRepo ur;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addUser(User user) throws FitBookPersistenceException {
        try {

            ur.save(user);
        } catch (Exception e) {
            throw new FitBookPersistenceException(e.toString());
        }

    }

    @Override
    public User getUserByCedula(String cedula) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from users where cedula=?", User.class);
            query.setParameter(1, cedula);
            if (query.getResultList().size() == 0) {
                throw new FitBookPersistenceException("User not found");
            }
            return (User) query.getSingleResult();
        } catch (Exception e) {
            throw new FitBookPersistenceException("Error no find User");
        }
    }

    @Override
    public User getUserByEmail(String email) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from users where email=?", User.class);
            query.setParameter(1, email);
            if (query.getResultList().size() == 0) {
                throw new FitBookPersistenceException("User not found");
            }
            return (User) query.getSingleResult();
        } catch (Exception e) {
            throw new FitBookPersistenceException(e.toString());
        }
    }

    @Override
    @Transactional
    public void changeBoxIdFromUser(int idBox, String mail) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("update users set boxid=? where email=?");
            query.setParameter(1, idBox);
            query.setParameter(2, mail);
            query.executeUpdate();
        } catch (Exception e) {
            throw new FitBookPersistenceException(e.toString());
        }
    }

    @Override
    @Transactional
    public void unrollForBoxByEmail(String email) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("update users set boxid=null where email=?");
            query.setParameter(1, email);
            query.executeUpdate();
        } catch (Exception e) {
            throw new FitBookPersistenceException(e.toString());
        }
    }

    @Override
    @Transactional
    public void changeUrlPhotoFromUser(String url, String mail) throws FitBookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("update users set url=? where email=?");
            query.setParameter(1, url);
            query.setParameter(2, mail);
            query.executeUpdate();
        } catch (Exception e) {
            throw new FitBookPersistenceException(e.toString());
        }
        
    }
}
