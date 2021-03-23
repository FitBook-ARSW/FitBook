package edu.eci.arsw.app.fitbook.persistence.cache.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.app.fitbook.model.Publication;
import edu.eci.arsw.app.fitbook.persistence.cache.IFitbookCache;

@Repository
public class FitbookCache implements IFitbookCache{

    public static final String POST_KEY = "edu:eci:arsw:fitbook:post";

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public FitbookCache(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.expire("Fitbook-cache", 1, TimeUnit.MINUTES);
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    @Override
    public List<Publication> getAllPublications() {
        return (List<Publication>) hashOperations.values("Fitbook-cache");
    }
    
}
