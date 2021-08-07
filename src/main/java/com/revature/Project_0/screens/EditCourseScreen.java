package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class EditCourseScreen extends Screen {

    public EditCourseScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("EditCourseScreen", "/edit-course", consoleReader, router);
    }

    @Override
    public void render() throws IOException {

        System.out.println("\nEdit course screen\n\n" +
                "Please select an option:\n" +
                "1) Edit a Course\n" +
                "2) Add Courses\n" +
                "3) Remove Courses\n" +
                "4) Previous Screen\n" +
                "5) Return to Dashboard.\n");

        String userSelection  = consoleReader.readLine();

        switch(userSelection)
        {
            case "1":
                System.out.println("Enter the Name or abbreviation for the course\n" +
                        "You would like to Edit:");
                String markedForDeletion = consoleReader.readLine();
                //TODO: verify course exists
                System.out.println("Which field would you like to edit?\n\n" +
                        "1) Course Name\n" +
                        "2) Course abbreviation\n" +
                        "3) Course description.\n" +
                        "4) Close Course to new students/withdrawal requests\n");

                String userSelection2 = consoleReader.readLine();
                //TODO verify input, update database.
                switch (userSelection2){
                    case "1":
                        System.out.println("Enter the new course name.");
                        break;
                    case "2":
                        System.out.println("Enter the new course abbreviation.");
                        break;
                    case "3":
                        System.out.println("Enter the new course description.");
                        break;
                    case "4":
                        System.out.println("Course closed.");
                        break;
                    default:
                        System.out.println("Invalid entry, canceling edit process...");

                }
                break;
            case "2":
                router.navigate("/new-course");
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
