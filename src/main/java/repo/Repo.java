package repo;

import model.Entity;

public interface Repo<E extends Entity> {

    /**
     * Inserts entity in Database
     *
     * @param entity entity to be insert
     * @return null - if insertion done, not-null - update done
     */
    E insert(Entity entity);

    /**
     * Finds entity by id
     *
     * @param id id
     * @return null if entity is not in database, E entity with that id
     */
    E findById(long id);

    /**
     * Deletes the entity form database
     *
     * @param entity entity to be deleted
     * @return true if delete done, false elese
     */
    boolean delete(Entity entity);
}
