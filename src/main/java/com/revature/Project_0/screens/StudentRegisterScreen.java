package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentRegisterScreen extends Screen {

    public StudentRegisterScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("StudentRegisterScreen", "/student-registration", consoleReader, router);
    }

    @Override
    public void render() {

        //TODO prompt user for information, validate it, then compare it against the database.
        //  Lastly, add the user to the database if there are no issues.
        //      Not finally because that would add it anyways. :)

    }
}
