package com.revature.Project_0.screens;

import com.revature.Project_0.services.UserCoursesService;
import com.revature.Project_0.util.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class RegisteredCoursesScreen extends Screen {

    private final Logger logger = LogManager.getLogger(NewStudentScreen.class);
    private final UserCoursesService userCoursesService;

    public RegisteredCoursesScreen(BufferedReader consoleReader, ScreenRouter router, UserCoursesService userCoursesService) {
        super("RegisteredCoursesScreen", "/registered-courses", consoleReader, router);
        this.userCoursesService = userCoursesService;
    }

    @Override
    public void render() throws IOException {
        try {
            System.out.println("You have registered for the following courses:");
            System.out.println(userCoursesService.getCourses().toString());
        }catch (Exception e) {
            logger.error(e.getMessage());
            logger.debug("User not registered!");
            router.navigate("/welcome");
        }
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
