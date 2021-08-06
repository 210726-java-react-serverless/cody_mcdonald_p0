package com.revature.Project_0.screens;

import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class RemoveCourseScreen extends Screen {

    private final CourseService courseService;

    public RemoveCourseScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("RemoveCourseScreen", "/remove-course", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() throws IOException {
        //TODO Request course marked for deletion, will take shorthand and full course names
        //  E.G. "CS101" or "Computer Science 101"
        // if a valid course is entered, delete that course from the students' course list and then remove the course from the database
    }
}
