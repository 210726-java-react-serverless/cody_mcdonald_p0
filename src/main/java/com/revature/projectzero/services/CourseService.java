package com.revature.projectzero.services;

import com.revature.projectzero.util.exceptions.CourseNotOpenException;
import com.revature.projectzero.util.exceptions.InvalidEntryException;
import com.revature.projectzero.documents.Course;
import com.revature.projectzero.repositories.CourseRepository;
import com.revature.projectzero.util.exceptions.NoSuchCourseException;
import com.revature.projectzero.util.exceptions.ResourcePersistenceException;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course add(Course newCourse) {

        if (!isCourseValid(newCourse)) {
            System.out.println("Invalid course data provided!");
            throw new InvalidEntryException("User provided invalid course information.");
        }else if (courseRepo.findCourseByName(newCourse.getCourseName()) != null)
        {
            System.out.println("Provided course already exists!");
            throw new ResourcePersistenceException("User provided a course name that already exists.");
        }else if (courseRepo.findCourseByAbbreviation(newCourse.getCourseAbbreviation()) != null)
        {
            System.out.println("A course with the existing abbreviation already exists!");
            throw new ResourcePersistenceException("User provided an abbreviation that already exists.");
        }

        return courseRepo.save(newCourse);

    }

    public void removeCourse(Course course){

        courseRepo.removeCourse(course);

    }

    public void updateCourseName(Course editingCourse, String newName){

        if (newName==null||newName.trim().equals(""))
        {
            System.out.println("Course name cannot be blank!");
            throw new InvalidEntryException("User provided a blank Course Name.");
        }else if (courseRepo.findCourseByName(newName) != null)
        {
            System.out.println("A course by that name already exists!");
            throw new ResourcePersistenceException("User provided a course name that already exists.");
        }

        courseRepo.updatingCourseName(editingCourse, newName);

    }
    public void updateCourseAbv(Course editingCourse, String newabv){

        if (newabv==null||newabv.trim().equals(""))
        {
            System.out.println("Course abbreviation cannot be blank!");
            throw new InvalidEntryException("User provided a blank course abbreviation.");
        }else if (courseRepo.findCourseByAbbreviation(newabv) != null)
        {
            System.out.println("A course with that abbreviation already exists!");
            throw new ResourcePersistenceException("User provided an abbreviation that already exists.");
        }

        courseRepo.updatingCourseAbv(editingCourse, newabv);

    }
    public void updateCourseDesc(Course editingCourse, String newDesc){

        if (newDesc==null||newDesc.trim().equals(""))
        {
            System.out.println("Course description cannot be blank!");
            throw new InvalidEntryException("User provided a blank course description.");
        }

        courseRepo.updatingCourseDesc(editingCourse, newDesc);

    }

    public void toggleOpen(Course course){

        courseRepo.openClose(course);
    }

    public Course verifyCourse(String abv){

        if(abv==null||abv.trim().equals(""))
        {
            throw new InvalidEntryException("Invalid abbreviation provided");

        }else if (courseRepo.findCourseByAbbreviation(abv) == null)
        {
            throw new ResourcePersistenceException("No course found with provided abbreviation!");
        }

        return courseRepo.findCourseByAbbreviation(abv);

    }

    public Course verifyCourseOpenByAbbreviation(String abv){

        if(abv==null||abv.trim().equals(""))
        {
            throw new InvalidEntryException("Invalid abbreviation provided");

        }else if (courseRepo.findCourseByAbbreviation(abv) == null)
        {
            throw new NoSuchCourseException("No course found with provided abbreviation!");
        }else if(!courseRepo.findCourseByAbbreviation(abv).isOpen())
        {
            throw new ResourcePersistenceException("The registration and withdrawal windows for this course have closed!");
        }

        return courseRepo.findCourseByAbbreviation(abv);

    }

    public Course verifyCourseOpenByName(String courseName){

        if(courseName==null||courseName.trim().equals(""))
        {
            throw new InvalidEntryException("Invalid course name provided");

        }else if (courseRepo.findCourseByName(courseName) == null)
        {
            System.out.println("No course found with provided name!");
            throw new NoSuchCourseException("No course found with provided name!");
        }else if(!courseRepo.findCourseByName(courseName).isOpen())
        {
            System.out.println("The registration and withdrawal windows for this course have closed!");
            throw new CourseNotOpenException("User attempted to join or withdraw from a closed course.");
        }

        return courseRepo.findCourseByAbbreviation(courseName);

    }

    public List<Course> getCourses(){
        return courseRepo.retrieveCourses();
    }

    public boolean isCourseValid(Course course) {
        if (course == null) return false;
        if (course.getCourseName() == null || course.getCourseName().trim().equals("")) return false;
        if (course.getCourseAbbreviation() == null || course.getCourseAbbreviation().trim().equals("")) return false;
        else return course.getCourseDetail() != null && !course.getCourseDetail().trim().equals("");
    }

}
