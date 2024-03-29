package edu.eci.arsw.app.fitbook.persistence.cache;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Like;
import edu.eci.arsw.app.fitbook.model.Publication;

public interface IFitbookCache {
    Publication get(int publication_id) throws Exception;
    void put(Publication publication);
    boolean exists(int publication_id);
    List<Like> getAllLike() throws Exception;
    List<Publication> getAll() throws Exception;
    void delete(int publication_id) throws Exception;
}
