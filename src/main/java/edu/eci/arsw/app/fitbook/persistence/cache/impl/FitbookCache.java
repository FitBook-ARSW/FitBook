package edu.eci.arsw.app.fitbook.persistence.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.app.fitbook.model.Publication;
import edu.eci.arsw.app.fitbook.persistence.cache.IFitbookCache;

import java.util.List;

import javax.annotation.PostConstruct;

@Repository
public class FitbookCache implements IFitbookCache{

    public static final String KEY = "publications";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Publication> hashOperations;

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
    public List<Publication> getAll() {
        return hashOperations.values(KEY);
    }

    @Override
    public void put(Publication publication) {
        try {
            hashOperations.put(KEY, (long) publication.getId(), publication);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean exists(int publication_id) {
        return false;
    }
}
