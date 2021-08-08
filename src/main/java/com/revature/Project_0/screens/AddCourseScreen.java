package com.revature.Project_0.screens;

import com.revature.Project_0.documents.Course;
import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.util.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class AddCourseScreen extends Screen{

    private final Logger logger = LogManager.getLogger(NewStudentScreen.class);
    private final CourseService courseService;

    public AddCourseScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("AddCourseScreen", "/new-course", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() throws IOException {

        String courseName, courseAbv,courseDesc;


        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");

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
                    //TODO course entry validation
                    Course newCourse = new Course(courseName, courseAbv, courseDesc, true);
                    courseService.add(newCourse);
                    System.out.println("Course registered!");
                    router.navigate("/new-course");
                }catch (Exception e) {
                    logger.error(e.getMessage());
                    logger.debug("Course not registered!");
                    router.navigate("/new-course");
                }

                System.out.println("Adding the course to the database...");
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
