package com.revature.Project_0.screens;

import com.revature.Project_0.util.AppState;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class WelcomeScreen extends Screen {


    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
    }

    @Override
    public void render() throws IOException {
        // Output welcome message and display options.
        String menu = "\nWelcome to the Student Management Console.\n" +
                "1) Login\n" +
                "2) New Student\n" +
                "3) Exit application\n" +
                "> ...\n";

        System.out.print(menu);

        String userSelection  = consoleReader.readLine();

        switch(userSelection) {
            case "1":
                router.navigate("/login");
                break;
            case "2":
                router.navigate("/new-student");
                break;
            case "3":
                System.out.println("Oh, okay...");
                AppState.setAppRunning(false);
                break;
            default:
                System.out.println("Invalid entry, please try again.");

        }



    }



}
