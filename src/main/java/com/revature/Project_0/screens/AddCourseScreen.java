package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.revature.Project_0.util.AppState.closeApp;


public class AddCourseScreen extends Screen{

    public AddCourseScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("AddCourseScreen", "/new-course", consoleReader, router);
    }

    @Override
    public void render() throws IOException {

        String courseName, courseAbv,courseDesc;


        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");

        System.out.println("New Course Screen:\n");

        System.out.println("Please select an option:\n" +
                "1) Add a Course\n" +
                "2) Edit Courses\n" +
                "3) Remove Courses\n" +
                "4) Previous Screen\n" +
                "5) Return to Dashboard.\n");

        String userSelection  = consoleReader.readLine();
        switch (userSelection)
        {
            case "1":
                System.out.print("Course Name:");
                courseName = consoleReader.readLine();

                System.out.print("Course Abbreviation:");
                courseAbv = consoleReader.readLine();

                System.out.print("Course Description:");
                courseDesc = consoleReader.readLine();

                //TODO validate, print to database
                System.out.println("Adding the course to the database...");
                break;
            case "2":
                router.navigate("/edit-course");
                break;
            case "3":
                router.navigate("/remove-course");
                break;
            case "4":
                router.goBack();
                break;
            case "5":
                router.navigate("/faculty-home");
                break;
            default:
                System.out.println("Invalid entry. Please try again.");
        }





    }
}
