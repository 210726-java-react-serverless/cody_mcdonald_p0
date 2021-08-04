package com.revature.Project_0.repositories;

public interface CrudRepository<T> {

    T findByID(int id);
    T save(T newResource);
    boolean update(T updatedResource);
    boolean deleteByID(int id);

}
