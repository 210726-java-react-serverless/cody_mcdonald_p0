package com.revature.Project_0.screens;

import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class RegisteredCoursesScreen extends Screen {

    private final CourseService courseService;

    public RegisteredCoursesScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("RegisteredCoursesScreen", "/registered-courses", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() throws IOException {

        //TODO check if students have > 0 registered courses
        // if they do, then print them to the command line
        // else, print "You are not registered for any courses!"

    }
}
