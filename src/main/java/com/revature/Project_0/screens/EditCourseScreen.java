package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class EditCourseScreen extends Screen {

    public EditCourseScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("EditCourseScreen", "/edit-course", consoleReader, router);
    }

    @Override
    public void render() {

        //TODO Request course to be edited, check the database for entered course
        //  if the course is not found, ask if they would like to add it
        //  else if the course is found, print out the modifiable fields for the course
        //  Iterate through the fields that can be modified
        // validate the data, if there are no issues then apply the updates to database

    }
}
