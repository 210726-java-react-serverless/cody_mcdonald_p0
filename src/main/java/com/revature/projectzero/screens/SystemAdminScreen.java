package com.revature.projectzero.screens;

import com.revature.projectzero.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class SystemAdminScreen extends Screen{

    public SystemAdminScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("SystemAdminScreen", "/sys-admin", consoleReader, router);
    }

    /*
     * System admin screen for unlocking the console, (if i implement that)
     *  a little side project for myself.
     *
     *
     */

    @Override
    public void render() throws IOException {

        System.out.println("Awaken, my master.\n");
        System.out.println("1) Add new Faculty account.\n" +
                "2) Add new Student account\n" +
                "3) Add a new Course\n" +
                "4) Remove a Faculty account\n" +
                "5) Remove a Student account\n" +
                "6) Remove a Course\n" +
                        "7) Edit a user's account\n" +
                        "8) Unlock the console\n");
        System.out.println("Nothing to do for now...");

        router.navigate("/welcome");



    }
}
