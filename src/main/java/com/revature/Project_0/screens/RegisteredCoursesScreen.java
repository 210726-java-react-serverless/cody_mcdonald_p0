package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class RegisteredCoursesScreen extends Screen {

    public RegisteredCoursesScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("RegisteredCoursesScreen", "/registered-courses", consoleReader, router);
    }

    @Override
    public void render() {

        //TODO check if students have > 0 registered courses
        // if they do, then print them to the command line
        // else, print "You are not registered for any courses!"

    }
}
