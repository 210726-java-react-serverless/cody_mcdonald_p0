package com.revature.Project_0.screens;

import com.revature.Project_0.documents.AppUser;
import com.revature.Project_0.services.UserService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class StudentDashboardScreen extends Screen {

    private final UserService userService;

    public StudentDashboardScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("StudentHomeScreen", "/student-home", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws IOException {

        AppUser currentUser = userService.getSession().getCurrentUser();

        System.out.println("Welcome, "+currentUser.getFirstName()+".");
        System.out.println("Please select an option." +
                "\n1) View available courses." +
                "\n2) Register for a course." +
                "\n3) View registered courses" +
                "\n4) Cancel course registration." +
                "\n5) Log out.");

        String userSelection = consoleReader.readLine();

        switch (userSelection) {
            case "1":
                router.navigate("/courses");
                break;
            case "2":
                router.navigate("/join-course");
                break;
            case "3":
                router.navigate("/registered-courses");
                break;
            case "4":
                router.navigate("/course-withdrawal");
            case "5":
                System.out.println("Logging out...");
                router.navigate("/welcome");
                router.deleteHistory();
                System.out.println("History deleted!");
                break;
            default:
                System.out.println("Invalid entry. Please try again.");

        }
    }
}
