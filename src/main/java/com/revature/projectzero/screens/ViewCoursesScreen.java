package com.revature.projectzero.screens;

import com.revature.projectzero.documents.Course;
import com.revature.projectzero.services.CourseService;
import com.revature.projectzero.util.ScreenRouter;

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

        System.out.println("The currently available courses are:\n");

        for (Course a : courseService.getCourses())
        {
            System.out.println("Course name: "+a.getCourseName()+"\n"
                    +"Course Abbreviation: "+a.getCourseAbbreviation()+"\n"
                    +"Course Details: "+a.getCourseDetail()+"\n");

        }


        router.goBack();



    }
}
