package com.revature.Project_0.services;

import com.revature.Project_0.documents.UserCourses;
import com.revature.Project_0.repositories.UserCoursesRepository;
import com.revature.Project_0.util.UserSession;
import com.revature.Project_0.util.exceptions.AlreadyRegisteredForCourseException;
import com.revature.Project_0.util.exceptions.InvalidEntryException;
import com.revature.Project_0.util.exceptions.NoCoursesJoinedException;

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

    public void joinCourse(String courseName){

        //TODO validate that the course is not already registered for

        for (String course:userCourseListRepo.findRegisteredCoursesByUsername(
                session.getCurrentUser().getUsername())) {
            if(courseName.equals(course))
                throw new AlreadyRegisteredForCourseException("You have already registered for this course!");
        }

        userCourseListRepo.joinCourse(courseName,session.getCurrentUser().getUsername());
    }


    public void removeCourse() {

    }

    public List<String> getCourses(){

        if(userCourseListRepo.findRegisteredCoursesByUsername(
                session.getCurrentUser().getUsername()).size()==0){
            throw new NoCoursesJoinedException("You have not registered for any courses!");
        }

        return userCourseListRepo.findRegisteredCoursesByUsername(session.getCurrentUser().getUsername());
    }



}
