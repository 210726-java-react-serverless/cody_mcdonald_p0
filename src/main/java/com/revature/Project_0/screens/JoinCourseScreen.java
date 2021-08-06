package com.revature.Project_0.screens;

import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class JoinCourseScreen extends Screen {

    public JoinCourseScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("JoinCourseScreen", "/join-course", consoleReader, router);
    }

    @Override
    public void render() throws IOException {
        System.out.println("Please enter the name or ID of the course you would like to join.\n" +
                "\nFor a list of courses, enter L or List" +
                "\nTo go back, enter B or Back.");
        //TODO take input from user, compare it against courses in the database.
        //  if the course is found and available, add the student to the course
        //     else if the course is not available, inform the user
        //      else if the course is not found, suggest a random course (for fun) :)


    }
}
