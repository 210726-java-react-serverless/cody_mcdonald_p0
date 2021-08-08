package com.revature.Project_0.services;

import com.revature.Project_0.util.exceptions.InvalidEntryException;
import com.revature.Project_0.documents.Course;
import com.revature.Project_0.repositories.CourseRepository;
import com.revature.Project_0.util.exceptions.ResourcePersistenceException;

import java.util.List;

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

    public void updateCourseName(Course editingCourse, String newName){

        if (newName==null||newName.trim().equals(""))
        {
            throw new InvalidEntryException("Course name cannot be blank!");
        }else if (courseRepo.findCourseByName(editingCourse.getCourseName()) != null)
        {
            throw new ResourcePersistenceException("A course by that name already exists!");
        }

        courseRepo.updatingCourseName(editingCourse, newName);

    }
    public void updateCourseAbv(Course editingCourse, String newabv){

        if (newabv==null||newabv.trim().equals(""))
        {
            throw new InvalidEntryException("Course abbreviation cannot be blank!");
        }else if (courseRepo.findCourseByAbbreviation(newabv) != null)
        {
            throw new ResourcePersistenceException("A course by that name already exists!");
        }

        courseRepo.updatingCourseAbv(editingCourse, newabv);

    }
    public void updateCourseDesc(Course editingCourse, String newDesc){

        if (newDesc==null||newDesc.trim().equals(""))
        {
            throw new InvalidEntryException("Course description cannot be blank!");
        }

        courseRepo.updatingCourseDesc(editingCourse, newDesc);

    }

    public Course verifyCourse(String abv){

        if(abv==null||abv.trim().equals(""))
        {
            throw new InvalidEntryException("Invalid abbreviation provided");
        }

        return courseRepo.findCourseByAbbreviation(abv);

    }

    public List<Course> getCourses(){
        return courseRepo.retrieveCourses();
    }

    public boolean isCourseValid(Course course) {
        if (course == null) return false;
        if (course.getCourseName() == null || course.getCourseName().trim().equals("")) return false;
        return course.getCourseAbbreviation() != null && !course.getCourseAbbreviation().trim().equals("");
    }

}
