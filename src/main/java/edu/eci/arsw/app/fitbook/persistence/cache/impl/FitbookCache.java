package edu.eci.arsw.app.fitbook.persistence.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.app.fitbook.model.Like;
import edu.eci.arsw.app.fitbook.model.Publication;
import edu.eci.arsw.app.fitbook.persistence.IPublicationPersistence;
import edu.eci.arsw.app.fitbook.persistence.cache.IFitbookCache;

import java.util.List;

import javax.annotation.PostConstruct;

@Repository
public class FitbookCache implements IFitbookCache{

    public static final String KEY = "publications";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Publication> hashOperations;
    private HashOperations<String, Long, Like> hashOperationsL;

    @Autowired
    IPublicationPersistence pp;

    @Autowired
	public FitbookCache(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

    @PostConstruct
	private void intializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}

    @Override
    public Publication get(int publication_id) throws Exception {
        try {
            return hashOperations.get(KEY, (long) publication_id);
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        
    }

    @Override
    public List<Publication> getAll() throws Exception {
        try {
            return hashOperations.values(KEY);
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        
    }

    @Override
    public void put(Publication publication) {
        try {
            System.out.println(publication.getMail());
            hashOperations.put(KEY, (long) publication.getId(), publication);
            System.out.println("Do with out error's");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean exists(int publication_id) {
        return false;
    }

    @Override
    public void delete(int publication_id) throws Exception {
        try {
            hashOperations.delete(KEY,(long) publication_id);
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    @Scheduled(fixedDelay = 300000)
    public void reseltHashOperation() throws Exception {
        List<Publication> oldPublications = getAll();
        for(int i = 0; i < oldPublications.size(); i++){
            delete(oldPublications.get(i).publication_id);
        }
        List<Publication> newPublications = pp.getAllPublications();
        for(int i = 0; i<newPublications.size(); i++){
            put(newPublications.get(i));
        }
    }
    @Override
    public List<Like> getAllLike() throws Exception {
        try {
            return hashOperationsL.values(KEY);
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }
}
