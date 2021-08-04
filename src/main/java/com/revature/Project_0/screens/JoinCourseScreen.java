package com.revature.Project_0.screens;

import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class JoinCourseScreen extends Screen {

    public JoinCourseScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("JoinCourseScreen", "/join-course", consoleReader, router);
    }

    @Override
    public void render() {
        System.out.println("Please enter the Course you would like to join." +
                "\nCourse abbreviations and full names are accepted.");
        //TODO take input from user, compare it against courses in the database.
        //  if the course is found and available, add the student to the course
        //     else if the course is not available, inform the user
        //      else if the course is not found, suggest a random course (for fun) :)


    }
}
