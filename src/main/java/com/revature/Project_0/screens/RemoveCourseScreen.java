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

         System.out.println("\nCourse Removal Screen\n\n" +
                "Please select an option:\n" +
                "1) Begin removal process\n" +
                "2) Add Courses\n" +
                "3) Edit Courses\n" +
                "4) Previous Screen\n" +
                "5) Return to Dashboard.\n");

        String userSelection  = consoleReader.readLine();

        switch(userSelection)
        {
            case "1":
                System.out.println("Enter the Name, abbreviation, or ID of the course\n" +
                        "You would like to remove:");
                String markedForDeletion = consoleReader.readLine();
                //TODO: verify
                System.out.println("This action cannot be undone, are you sure?\n" +
                        "1) Yes\n" +
                        "2) No\n");

                String userVerification = consoleReader.readLine();

                switch (userVerification){
                    case "1":
                        System.out.println("Removing class...");
                        //TODO remove the class from users' course lists and remove the course from the database
                        break;
                    case "2":
                        System.out.println("Canceling deletion process...");
                        break;
                    default:
                        System.out.println("Invalid entry, canceling deletion process...");

                }
                break;
            case "2":
                router.navigate("/new-course");
                break;
            case "3":
                router.navigate("/edit-course");
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
