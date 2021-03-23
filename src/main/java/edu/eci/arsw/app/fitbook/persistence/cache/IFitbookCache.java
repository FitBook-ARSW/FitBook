package edu.eci.arsw.app.fitbook.persistence.cache;

import java.util.List;

import edu.eci.arsw.app.fitbook.model.Publication;

public interface IFitbookCache {
    List<Publication> getAllPublications();
}
