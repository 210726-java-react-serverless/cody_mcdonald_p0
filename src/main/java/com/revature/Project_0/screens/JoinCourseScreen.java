package com.revature.Project_0.screens;

public class JoinCourseScreen extends Screen {

    public JoinCourseScreen() {
        super("JoinCourseScreen", "/join-course");
    }

    @Override
    public void render() {
        System.out.println("Please enter the Course you would like to join." +
                "\nCourse abbreviations and full names are accepted.");
        //TODO take input from user, compare it against courses in the database.
        //  if the course is found and available, add the student to the course
        //     else if the course is not available, inform the user
        //      else if the course is not found, suggest a random course (for fun) :)


    }
}