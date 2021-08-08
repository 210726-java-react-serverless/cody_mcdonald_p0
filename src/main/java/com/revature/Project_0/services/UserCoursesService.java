package com.revature.Project_0.services;

import com.revature.Project_0.documents.UserCourses;
import com.revature.Project_0.repositories.UserCoursesRepository;
import com.revature.Project_0.util.UserSession;

public class UserCoursesService {

    private final UserCoursesRepository userCourseListRepo;
    private final UserSession session;

    public UserCoursesService(UserCoursesRepository userCourseRepo, UserSession session) {
        this.userCourseListRepo = userCourseRepo;
        this.session = session;
    }

    public UserCourses initialize(UserCourses newUserCourseList){
        return userCourseListRepo.save(newUserCourseList);
    }

    public void removeCourse(){

    }



}
