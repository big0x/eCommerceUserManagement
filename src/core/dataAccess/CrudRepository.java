package core.dataAccess;

import core.entities.Entity;
import core.exceptions.BusinessException;

import java.util.ArrayList;

public interface CrudRepository<T extends Entity> {
    void add(T entity) throws BusinessException;

    void update(T entity) throws BusinessException;

    void delete(T entity) throws BusinessException;

    ArrayList<T> getAll();
}
