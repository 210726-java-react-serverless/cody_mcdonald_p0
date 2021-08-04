package com.revature.Project_0.repositories;

import com.revature.Project_0.models.AppUser;

public class UserRepository implements CrudRepository<AppUser>{

    //TODO print user info to repository

    @Override
    public AppUser findByID(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newResource) {
        return null;
    }

    @Override
    public boolean update(AppUser updatedResource) {
        return false;
    }

    @Override
    public boolean deleteByID(int id) {
        return false;
    }
}
