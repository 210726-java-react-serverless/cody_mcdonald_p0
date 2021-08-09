package com.revature.projectzero.screens;

import com.revature.projectzero.documents.Course;
import com.revature.projectzero.services.CourseService;
import com.revature.projectzero.util.ScreenRouter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;



public class AddCourseScreen extends Screen{

    private final Logger logger = LogManager.getLogger(AddCourseScreen.class);
    private final CourseService courseService;

    public AddCourseScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("AddCourseScreen", "/new-course", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() throws IOException {

        String courseName;
        String courseAbv;
        String courseDesc;

        System.out.println("New Course Screen:\n");

        System.out.println("Please select an option:\n" +
                "1) Add a Course\n" +
                "2) Edit Courses\n" +
                "3) Remove Courses\n" +
                "4) Previous Screen\n" +
                "5) Return to Dashboard.\n");

        String userSelection  = consoleReader.readLine();

        switch (userSelection)
        {
            case "1":
                System.out.print("Course Name: ");
                courseName = consoleReader.readLine();

                System.out.print("Course Abbreviation: ");
                courseAbv = consoleReader.readLine();

                System.out.print("Course Description: ");
                courseDesc = consoleReader.readLine();

                try{
                    Course newCourse = new Course(courseName, courseAbv, courseDesc, true);
                    courseService.add(newCourse);
                    System.out.println("Course registered!");
                }catch (Exception e) {
                    logger.error(e.getMessage());
                    logger.debug("Course not registered!");
                }
                break;
            case "2":
                router.navigate("/edit-course");
                break;
            case "3":
                router.navigate("/remove-course");
                break;
            case "4":
                router.goBack();
                break;
            case "5":
                router.navigate("/faculty-home");
                break;
            default:
                System.out.println("Invalid entry. Please try again.");
        }





    }
}
