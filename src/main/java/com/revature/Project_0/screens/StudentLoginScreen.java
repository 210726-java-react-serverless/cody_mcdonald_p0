package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentLoginScreen extends Screen {

    public StudentLoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("StudentLoginScreen", "/student-login", consoleReader, router);
    }

    @Override
    public void render() {

        //TODO prompt user for information, validate it, then compare it against the database.
        //  Lastly, log the user in if there are no issues.
        //      Not finally because that would log them in anyways. :)
    }
}
