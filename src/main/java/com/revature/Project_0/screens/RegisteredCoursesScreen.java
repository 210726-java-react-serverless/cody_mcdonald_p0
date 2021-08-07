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
        System.out.println("You have registered for the following courses:");
        //TODO pull registered courses from database
        System.out.println("Please select an option.\n" +
                "1) Register for a course\n" +
                "2) Withdraw from a course\n" +
                "3) Go back\n" +
                "4) Return to dashboard\n");

        String userSelection  = consoleReader.readLine();

        switch (userSelection)
        {
            case "1":
                router.navigate("/join-course");
                break;
            case "2":
                router.navigate("/course-withdrawal");
                break;
            case "3":
                router.goBack();
                break;
            case "4":
                router.navigate("/student-home");
                break;
            default:
                System.out.println("Invalid entry. Please try again.");
        }

        //TODO check if students have > 0 registered courses
        // if they do, then print them to the command line
        // else, print "You are not registered for any courses!"

    }
}
