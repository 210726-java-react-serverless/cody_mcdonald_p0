package com.revature.Project_0.repositories;

import com.revature.Project_0.documents.AppUser;
import com.revature.Project_0.documents.Course;

public class CourseRepository implements CrudRepository<Course> {

    public Course findCourseByName(String courseName) {
        return null;
    }

    public Course findCourseByAbbreviation(String courseAbv) {
        return null;
    }

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
