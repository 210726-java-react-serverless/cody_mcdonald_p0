package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class SystemAdminScreen extends Screen{

    public SystemAdminScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("SystemAdminScreen", "/sys-admin", consoleReader, router);
    }

    /*
     * System admin account for unlocking the console,
     *  a little side challenge for myself.
     *
     *
     */

    @Override
    public void render() {

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
