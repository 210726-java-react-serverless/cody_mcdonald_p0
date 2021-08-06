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

        System.out.println("Edit course screen\n");

        System.out.println("Please enter the name or ID of the course you would like to Edit.\n" +
                "For a list of courses and their IDs, enter L or List.\n" +
                "To go back, enter B or Back.");

        String userSelection  = consoleReader.readLine();

        switch(userSelection)
        {
            case "L":
            case "List":
                System.out.println("Printing course list...");
                break;
            case "B":
            case "Back":
                router.goBack();
                break;
            default:
                System.out.println("Invalid entry. Please try again.");
        }

        //TODO Request course to be edited, check the database for entered course
        //  if the course is not found, ask if they would like to add it
        //  else if the course is found, print out the modifiable fields for the course
        //  Iterate through the fields that can be modified
        // validate the data, if there are no issues then apply the updates to database

    }
}
