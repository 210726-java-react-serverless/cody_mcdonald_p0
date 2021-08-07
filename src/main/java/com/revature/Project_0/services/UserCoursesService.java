package com.revature.Project_0.services;

import com.revature.Project_0.documents.AppUser;
import com.revature.Project_0.documents.UserCourses;
import com.revature.Project_0.repositories.UserCoursesRepository;
import com.revature.Project_0.repositories.UserRepository;
import com.revature.Project_0.util.UserSession;

public class UserCoursesService {

    private final UserCoursesRepository usercourseListRepo;
    private final UserSession session;

    public UserCoursesService(UserCoursesRepository userCourseRepo, UserSession session) {
        this.usercourseListRepo = userCourseRepo;
        this.session = session;
    }

    public UserCourses initialize(UserCourses newUserCourseList){


        return usercourseListRepo.save(newUserCourseList);

    }

}
