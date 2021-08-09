package com.revature.projectzero.services;

import com.revature.projectzero.documents.UserCourses;
import com.revature.projectzero.repositories.UserCoursesRepository;
import com.revature.projectzero.util.UserSession;
import com.revature.projectzero.util.exceptions.AlreadyRegisteredForCourseException;
import com.revature.projectzero.util.exceptions.NoCoursesJoinedException;
import com.revature.projectzero.util.exceptions.NotRegisteredForCourseException;

import java.util.List;

public class UserCoursesService {

    private final UserCoursesRepository userCourseListRepo;

    private final UserSession session;

    public UserCoursesService(UserCoursesRepository userCourseRepo, UserSession session) {
        this.userCourseListRepo = userCourseRepo;
        this.session = session;
    }

    public void initialize(UserCourses newUserCourseList){
        userCourseListRepo.save(newUserCourseList);
    }

    public void joinCourse(String courseToRemove){

        // Grabbing values to iterate over here instead of on one line so it looks nicer and is easier to follow
        String un = session.getCurrentUser().getUsername();
        List<String> userCourses = userCourseListRepo.findRegisteredCoursesByUsername(un);

        for (String course:userCourses) {
            if(courseToRemove.equals(course))
                throw new AlreadyRegisteredForCourseException("You have already registered for this course!");
        }

        userCourseListRepo.joinCourse(courseToRemove,session.getCurrentUser().getUsername());
    }


    public void leaveCourse(String courseToLeave) {

        String un = session.getCurrentUser().getUsername();
        List<String> userCourses = userCourseListRepo.findRegisteredCoursesByUsername(un);

        // Should not actually be reached, but keeping for posterity
        if (userCourses.isEmpty())
            throw new NoCoursesJoinedException("You have not registered for any courses!");

        userCourseListRepo.removeCourseFromUserList(courseToLeave,un);

    }

    public String verifyCourseEntry(List<String> joinedCourses, String userEntry){

        for (String course:joinedCourses)
        {
            if (course.equalsIgnoreCase(userEntry.toLowerCase()))
                return course;
        }

        System.out.println("You have not registered for a course by this name.");
        throw new NotRegisteredForCourseException("User attempted to withdraw for a course they were not enrolled in.");

    }

    public void updateCourseNameInUserList(String originalName, String newName){

        //TODO check if any users have registered for this course

        userCourseListRepo.updateCourseNameInAllUserLists(originalName, newName);

    }

    public void expungeCourse(String courseName){

        //TODO check if any users have registered for this course

        userCourseListRepo.removeCourseFromAllUserLists(courseName);

    }



    public List<String> getCourses(){

        if(userCourseListRepo.findRegisteredCoursesByUsername(
                session.getCurrentUser().getUsername()).isEmpty()){
            System.out.println("You have not registered for any courses!");
            throw new NoCoursesJoinedException("User has not registered for any courses.");
        }

        return userCourseListRepo.findRegisteredCoursesByUsername(session.getCurrentUser().getUsername());
    }



}
