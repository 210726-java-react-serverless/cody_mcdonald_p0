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

        System.out.println("Course removal screen\n");

        System.out.println("1) Begin the removal process\n" +
                "2) Print a list of courses\n" +
                "3) Go back\n" +
                "4) Return to dashboard\n");

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
                        //TODO remove the class from student's accounts and remove the class from the database
                        break;
                    case "2":
                        System.out.println("Canceling deletion process...");
                        break;
                    default:
                        System.out.println("Invalid entry, canceling deletion process...");

                }
                break;
            case "2":
                System.out.println("The courses are:");
                break;
            case "3":
                router.goBack();
                break;
            case "4":
                router.navigate("/faculty-home");
            default:
                System.out.println("Invalid entry. Please try again.");
        }

        //TODO Request course marked for deletion, will take shorthand and full course names
        //  E.G. "CS101" or "Computer Science 101"
        // if a valid course is entered, delete that course from the students' course list and then remove the course from the database
    }
}
