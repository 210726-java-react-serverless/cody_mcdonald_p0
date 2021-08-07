package com.revature.Project_0.screens;

import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class CourseWithdrawalScreen extends Screen {

    private final CourseService courseService;

    public CourseWithdrawalScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("RemoveCourseScreen", "/course-withdrawal", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() throws IOException {

        System.out.println("Course Withdrawal Screen.");

            // TODO: validate entry, verify class can be withdrawn from,
            //  then remove the class from the student's course list.

            System.out.println("Please Select an Option.\n" +
                    "1) Begin withdrawal process\n" +
                    "2) Previous screen\n" +
                    "3) View registered classes\n" +
                    "4) Return to Dashboard.\n");

            String userSelection = consoleReader.readLine();

            switch(userSelection)
            {
                case "1":
                    //TODO: verify that the student has any registered courses
                    System.out.println("Enter the Name, abbreviation, or ID of the course\n" +
                            "you would like to withdraw from:");
                    String markedForDeletion = consoleReader.readLine();
                    //TODO: verify
                    System.out.println("If you wish to attend this class, " +
                            "you must register again before the registration window closes\n" +
                            "Are you sure?\n" +
                            "1) Yes\n" +
                            "2) No\n");

                    String userVerification = consoleReader.readLine();

                    switch (userVerification){
                        case "1":
                            System.out.println("Withdrawing from class...");
                            //TODO remove the class from this student's account
                            System.out.println("Withdrawal successful!");
                            break;
                        case "2":
                            System.out.println("Canceling withdrawal process...");
                            break;
                        default:
                            System.out.println("Invalid entry, canceling withdrawal process...");

                    }
                    break;
                case "2":
                    router.goBack();
                    break;
                case "3":
                    router.navigate("/registered-courses");
                    break;
                case "4":
                    router.navigate("/student-home");
                default:
                    System.out.println("Invalid entry, returning to Dashboard...");
            }



    }
}
