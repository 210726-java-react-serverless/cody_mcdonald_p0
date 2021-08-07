package com.revature.Project_0.util;
import com.revature.Project_0.repositories.CourseRepository;
import com.revature.Project_0.repositories.UserRepository;
import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.services.UserService;
import com.revature.Project_0.screens.*;
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

        //Instantiate Screens
        router.addScreen(new WelcomeScreen(consoleReader, router))
                .addScreen(new AddCourseScreen(consoleReader, router, courseService))
                .addScreen(new CourseRegistrationScreen(consoleReader, router, courseService))
                .addScreen(new EditCourseScreen(consoleReader, router))
                .addScreen(new FacultyDashboardScreen(consoleReader, router))
                .addScreen(new RegisteredCoursesScreen(consoleReader, router, courseService))
                .addScreen(new RemoveCourseScreen(consoleReader, router, courseService))
                .addScreen(new StudentDashboardScreen(consoleReader, router))
                .addScreen(new LoginScreen(consoleReader, router, userService))
                .addScreen(new ViewCoursesScreen(consoleReader, router, courseService))
                .addScreen(new SystemAdminScreen(consoleReader, router))
                .addScreen(new newStudentScreen(consoleReader, router, userService))
                .addScreen(new CourseWithdrawalScreen(consoleReader, router, courseService));
        ;

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
