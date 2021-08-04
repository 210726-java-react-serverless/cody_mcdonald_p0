package com.revature.Project_0.services;

import com.revature.Project_0.exceptions.InvalidEntryException;
import com.revature.Project_0.models.Course;
import com.revature.Project_0.repositories.CourseRepository;

public class CourseService {

    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course register(Course newCourse) {

        if (!isCourseValid(newCourse)) {
            throw new InvalidEntryException("Invalid course data provided!");
        }

        return courseRepo.save(newCourse);

    }

    public Course login(String username, String password) {
        return null;
    }

    public boolean isCourseValid(Course course) {
        return false;
    }

}
