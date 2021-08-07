package com.revature.Project_0.services;

import com.revature.Project_0.util.exceptions.InvalidEntryException;
import com.revature.Project_0.documents.Course;
import com.revature.Project_0.repositories.CourseRepository;
import com.revature.Project_0.util.exceptions.ResourcePersistenceException;

public class CourseService {

    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course add(Course newCourse) {

        if (!isCourseValid(newCourse)) {
            throw new InvalidEntryException("Invalid course data provided!");
        }

        if (courseRepo.findCourseByName(newCourse.getCourseName()) != null)
        {
            throw new ResourcePersistenceException("Provided course already exists!");
        }

        if (courseRepo.findCourseByAbbreviation(newCourse.getCourseAbbreviation()) != null)
        {
            throw new ResourcePersistenceException("A course with the existing abbreviation already exists!");
        }

        return courseRepo.save(newCourse);

    }

    public Course login(String username, String password) {
        return null;
    }

    public boolean isCourseValid(Course course) {
        //TODO consolidate business logic
        return true;
    }

}
