package com.revature.Project_0.screens;

import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.services.UserService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class CourseRegistrationScreen extends Screen {

    private final CourseService courseService;

    public CourseRegistrationScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("CourseRegistrationScreen", "/join-course", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() throws IOException {

        System.out.println("Course Registration Screen:\n");
        System.out.println("1) Register for a course\n" +
                "2) View Available Courses\n" +
                "3) Cancel Course Registration\n" +
                "4) Go back" +
                "5) View Registered Courses\n" +
                "6) Return to dashboard\n");

        String userSelection  = consoleReader.readLine();
        switch (userSelection)
        {
            case "1":
                System.out.print("Enter the name, abbreviation, or ID of the course you would like to join:");
                String joiningCourse = consoleReader.readLine();
                System.out.println("Applying for course...");
                //TODO validate, update database

                System.out.println("Course application accepted!");
                break;
            case "2":
                router.navigate("/courses");
                break;
            case "3":
                router.navigate("/course-withdrawal");
                break;
            case "4":
                router.goBack();
                break;
            case "5":
                router.navigate("/student-home");
                break;
            case "6":
                router.navigate("/registered-courses");
            default:
                System.out.println("Invalid entry.");
        }

        //  TODO Print a list of available courses, will take shorthand and full course names
        //      E.G. "CS101" or "Computer Science 101"
        //      if a course is not listed/available but a student attempts to join,
        //      inform the student that the registration window for the course has ended.

    }
}
