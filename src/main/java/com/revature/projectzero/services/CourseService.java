package com.revature.projectzero.services;

import com.revature.projectzero.util.InputValidator;
import com.revature.projectzero.util.exceptions.CourseNotOpenException;
import com.revature.projectzero.util.exceptions.InvalidEntryException;
import com.revature.projectzero.documents.Course;
import com.revature.projectzero.repositories.CourseRepository;
import com.revature.projectzero.util.exceptions.NoSuchCourseException;
import com.revature.projectzero.util.exceptions.ResourcePersistenceException;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepo;
    private final InputValidator inputValidator;

    public CourseService(CourseRepository courseRepo, InputValidator inputValidator) {
        this.courseRepo = courseRepo;
        this.inputValidator = inputValidator;
    }

    public Course add(Course newCourse) {

        inputValidator.newCourseEntryValidator(newCourse);

        if (courseRepo.findCourseByName(newCourse.getCourseName()) != null)
        {
            System.out.println("Provided course already exists!");
            throw new ResourcePersistenceException("User provided a course name that already exists.");
        }
        if (courseRepo.findCourseByAbbreviation(newCourse.getCourseAbbreviation()) != null)
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


        inputValidator.newCourseNameValidator(editingCourse, newName);

        if (courseRepo.findCourseByName(newName) != null)
        {
            System.out.println("A course by that name already exists!");
            throw new ResourcePersistenceException("User provided a course name that already exists.");
        }

        courseRepo.updatingCourseName(editingCourse, newName);

    }
    public void updateCourseAbv(Course editingCourse, String newAbv){

        inputValidator.newCourseAbvValidator(editingCourse, newAbv);

        if (courseRepo.findCourseByAbbreviation(newAbv) != null)
        {
            System.out.println("A course with that abbreviation already exists!");
            throw new ResourcePersistenceException("User provided an abbreviation that already exists.");
        }

        courseRepo.updatingCourseAbv(editingCourse, newAbv);

    }
    public void updateCourseDesc(Course editingCourse, String newDesc){

        inputValidator.newCourseDetailsValidator(newDesc);

        courseRepo.updatingCourseDesc(editingCourse, newDesc);

    }

    public void toggleOpen(Course course){

        courseRepo.openClose(course);
    }

    public Course verifyCourse(String abv){

        if(abv==null||abv.trim().equals(""))
        {
            System.out.println("Abbreviation cannot be blank!");
            throw new InvalidEntryException("Invalid abbreviation provided.");
        }

        Course verifiedCourse = courseRepo.findCourseByAbbreviation(abv);

        if (verifiedCourse == null)
        {
            System.out.println("No course found with provided abbreviation!");
            throw new ResourcePersistenceException("No course found with provided abbreviation.");
        }

        return verifiedCourse;

    }

    public Course verifyCourseOpenByAbbreviation(String abv){

        if(abv==null||abv.trim().equals(""))
        {
            System.out.println("Invalid entry!");
            throw new InvalidEntryException("Blank entry.");

        }else if (courseRepo.findCourseByAbbreviation(abv) == null)
        {
            System.out.println("No course found with provided abbreviation!");
            throw new NoSuchCourseException("Invalid course abbreviation provided.");
        }else if(!courseRepo.findCourseByAbbreviation(abv).isOpen())
        {
            System.out.println("The registration and withdrawal windows for this course have closed!");
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
        return courseRepo.retrieveOpenCourses();
    }

    public boolean isCourseValid(Course course) {
        if ((course == null) || (course.getCourseName() == null) || course.getCourseName().trim().equals("") ||
                (course.getCourseAbbreviation() == null) || course.getCourseAbbreviation().trim().equals("") ||
                (course.getCourseDetail() == null) || course.getCourseDetail().trim().equals("")) {
            System.out.println("Fields cannot be empty!");
            return false;
        }
        if ((course.getCourseName().length()) <= (course.getCourseAbbreviation().length())){
            System.out.println("Please make the course abbreviation smaller than the course name.");
            return false;
        }
        else return true;
    }

}
