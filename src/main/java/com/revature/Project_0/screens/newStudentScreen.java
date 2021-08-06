package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class newStudentScreen extends Screen {

    public newStudentScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("newStudentScreen", "/new-student", consoleReader, router);
    }

    @Override
    public void render() {
        System.out.println("Under construction, please come again!");
        router.navigate("/welcome");
        //TODO prompt user for information, validate it, then compare it against the database.
        //  Lastly, add the user to the database if there are no issues.
        //      Not finally because that would add it anyways. :)

    }
}
