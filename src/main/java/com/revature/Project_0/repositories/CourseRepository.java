package com.revature.Project_0.repositories;

import com.revature.Project_0.models.Course;

public class CourseRepository implements CrudRepository<Course> {

    //TODO print course info to repository


    @Override
    public Course findByID(int id) {
        return null;
    }

    @Override
    public Course save(Course newResource) {
        return null;
    }

    @Override
    public boolean update(Course updatedResource) {
        return false;
    }

    @Override
    public boolean deleteByID(int id) {
        return false;
    }


}
