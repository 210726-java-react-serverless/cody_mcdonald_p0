package com.revature.Project_0.screens;

import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.services.UserService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class CourseRegistrationScreen extends Screen {

    private final CourseService courseService;

    public CourseRegistrationScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("CourseRegistrationScreen", "/join-course", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() {

        //  TODO Print a list of available courses, will take shorthand and full course names
        //      E.G. "CS101" or "Computer Science 101"
        //      if a course is not listed/available but a student attempts to join,
        //      inform the student that the registration window for the course has ended.

    }
}
