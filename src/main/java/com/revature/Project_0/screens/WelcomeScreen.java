package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.*;

import static com.revature.Project_0.util.AppState.closeApp;

public class WelcomeScreen extends Screen {


    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
    }

    @Override
    public void render() throws IOException {

        // For system admin use
//        TODO: make a class that handles this, put the password on the mongodb
//        Properties extra = new Properties();
//        extra.load(new FileReader("/src/main/resources/application.properties"));
//        String secret = extra.getProperty("secretpassword");

        // Output welcome message and display options.
        System.out.println("Welcome to the Student Management Console.\n" +
                "1) Login\n" +
                "2) New Student\n" +
                "3) Exit application\n" +
                "> ...\n");


        String userSelection  = consoleReader.readLine();
        switch (userSelection) {

            case "1":
                router.navigate("/login");
                break;
            case "2":
                router.navigate("/new-student");
                break;
            case "3":
                System.out.println("Exiting application...");
                closeApp();
                break;
            default:
                System.out.println("You provided an invalid value, please try again.");

        }

        //  would use a switch here but switches require constants
//        if(userSelection.equals(secret))
//            router.navigate("/sys-admin");
//        else if(userSelection.equals("1"))
//            router.navigate("/login");
//        else if (userSelection.equals("2"))
//            router.navigate("/new-student");
//        else if (userSelection.equals("3")){
//            System.out.println("Oh, okay...");
//            AppState.setAppRunning(false);}
//        else
//            System.out.println("Invalid entry, please try again.");

        }



    }




