package com.revature.Project_0.screens;

import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class ViewCoursesScreen extends Screen {

    private final CourseService courseService;

    public ViewCoursesScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("ViewCoursesScreen", "/courses", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() throws IOException {

        System.out.println("The current available courses are:\n");
        //TODO print out courses from database

        router.goBack();


        //  Take input from user that will print further details about a course or return the user to their Dashboard.

    }
}
