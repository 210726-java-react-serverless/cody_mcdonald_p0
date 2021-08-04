package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class AddCourseScreen extends Screen{

    public AddCourseScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("AddCourseScreen", "/new-course", consoleReader, router);
    }

    @Override
    public void render() {

        // TODO Iterate through a list of fields to be filled by the user
        //  Validate these fields, check the database for the same class
        //  and then add the class to the database if it's valid



    }
}
