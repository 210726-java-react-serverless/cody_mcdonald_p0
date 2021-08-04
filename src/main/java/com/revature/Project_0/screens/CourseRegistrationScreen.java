package com.revature.Project_0.screens;

import com.revature.Project_0.services.UserService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class CourseRegistrationScreen extends Screen {

    private final UserService userService;

    public CourseRegistrationScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("CourseRegistrationScreen", "/join-course", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() {

        //  TODO Print a list of available courses, will take shorthand and full course names
        //      E.G. "CS101" or "Computer Science 101"
        //      if a course is not listed/available but a student attempts to join,
        //      inform the student that the registration window for the course has ended.

    }
}
