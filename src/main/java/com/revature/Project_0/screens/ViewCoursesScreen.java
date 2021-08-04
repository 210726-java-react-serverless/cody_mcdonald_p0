package com.revature.Project_0.screens;

import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class ViewCoursesScreen extends Screen {

    private final CourseService courseService;

    public ViewCoursesScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("ViewCoursesScreen", "/courses", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() {

        System.out.println("The current courses are:");

        //TODO print out courses from database
        //  Take input from user that will print further details about a course or return the user to their Dashboard.

    }
}
