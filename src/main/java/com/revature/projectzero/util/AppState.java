package com.revature.projectzero.util;
import com.revature.projectzero.repositories.CourseRepository;
import com.revature.projectzero.repositories.UserCoursesRepository;
import com.revature.projectzero.repositories.UserRepository;
import com.revature.projectzero.services.CourseService;
import com.revature.projectzero.services.UserCoursesService;
import com.revature.projectzero.services.UserService;
import com.revature.projectzero.screens.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * The "heart" of the program.
 * Currently instantiates all of the screens.
 * Contains static variable and object references used by the Screens.
 *
 */

public class AppState {

    private static boolean appRunning;
    private final ScreenRouter router;


    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        // Create app components
        UserSession userSession = new UserSession();
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo, userSession);


        CourseRepository courseRepo = new CourseRepository();
        CourseService courseService = new CourseService(courseRepo);

        UserCoursesRepository courseListRepo = new UserCoursesRepository();
        UserCoursesService userCoursesService = new UserCoursesService(courseListRepo, userSession);

        //Instantiate Screens
        router.addScreen(new WelcomeScreen(consoleReader, router))
                .addScreen(new AddCourseScreen(consoleReader, router, courseService))
                .addScreen(new CourseRegistrationScreen(consoleReader, router, courseService, userCoursesService))
                .addScreen(new EditCourseScreen(consoleReader, router, courseService, userCoursesService))
                .addScreen(new FacultyDashboardScreen(consoleReader, router, userService))
                .addScreen(new RegisteredCoursesScreen(consoleReader, router, userCoursesService))
                .addScreen(new RemoveCourseScreen(consoleReader, router, courseService, userCoursesService))
                .addScreen(new StudentDashboardScreen(consoleReader, router, userService))
                .addScreen(new LoginScreen(consoleReader, router, userService))
                .addScreen(new ViewCoursesScreen(consoleReader, router, courseService))
                .addScreen(new SystemAdminScreen(consoleReader, router))
                .addScreen(new NewStudentScreen(consoleReader, router, userService, userCoursesService))
                .addScreen(new CourseWithdrawalScreen(consoleReader, router, courseService, userCoursesService));

        //TODO Kinda ugly and unnecessary to load all screens at once
        //  maybe implement a factory that loads screens as needed later


    }

    public void startup() {
        router.navigate("/welcome");        //display welcome screen on startup

        while (appRunning) {                    //while the app is running, render the current screen
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

    }
    /* Static methods can be accessed direction from an object's constructor
     *  Making this a static method makes it easily accessible and reduces code duplication
     *  --also making another appstate object for passing around would be rather dangerous.
     */
    public static void closeApp() {
        System.out.println("Shutting down...");
        AppState.appRunning = false;
    }
}
