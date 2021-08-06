package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

import static com.revature.Project_0.util.AppState.closeApp;

public class FacultyDashboardScreen extends Screen{

    public FacultyDashboardScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("FacultyHomeScreen", "/faculty-home", consoleReader, router);
    }

    @Override
    public void render() throws IOException {

        System.out.println("Faculty Screen\n\n" +
                "Welcome, admin.\n" +//TODO +username
                "Please select an option.\n" +
                "1) Add a new course.\n" +
                "2) Edit a course.\n" +
                "3) Remove a course.\n" +
                "4) Log out.\n" +
                "> ...\n");

        String userSelection  = consoleReader.readLine();

        switch (userSelection)
        {
            case "1":
                router.navigate("/new-course");
                break;
            case "2":
                router.navigate("/edit-course");
                break;
            case "3":
                router.navigate("/remove-course");
                break;
            case "4":
                System.out.println("Logging out...");
                router.navigate("/welcome");
                router.deleteHistory();
                System.out.println("History deleted!");
                break;
            default:
                System.out.println("Invalid entry. Please try again.");
        }

        //TODO Print available user options

    }
}
