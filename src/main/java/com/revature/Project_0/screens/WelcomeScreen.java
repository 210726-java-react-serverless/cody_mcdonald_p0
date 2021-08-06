package com.revature.Project_0.screens;

import com.revature.Project_0.util.AppState;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WelcomeScreen extends Screen {


    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
    }

    @Override
    public void render() throws IOException {
        // For system admin use
        InputStream input = new FileInputStream("C:/Users/Ke'Al/Desktop/revature/Training/p0/src/main/resources/application.properties");
        Properties extra = new Properties();
        extra.load(input);
        String secret = extra.getProperty("secretpassword");
input.close();
        // Output welcome message and display options.
        String menu = "\nWelcome to the Student Management Console.\n" +
                "1) Login\n" +
                "2) New Student\n" +
                "3) Exit application\n" +
                "> ...\n";

        System.out.print(menu);

        String userSelection  = consoleReader.readLine();


        //  would use a switch here but switches require constants
        if(userSelection.equals(secret))
            router.navigate("/sys-admin");
        else if(userSelection.equals("1"))
            router.navigate("/login");
        else if (userSelection.equals("2"))
            router.navigate("/new-student");
        else if (userSelection.equals("3")){
            System.out.println("Oh, okay...");
            AppState.setAppRunning(false);}
        else
            System.out.println("Invalid entry, please try again.");

        }



    }




