package com.revature.projectzero.services;

import com.revature.projectzero.documents.AppUser;
import com.revature.projectzero.repositories.UserCoursesRepository;
import com.revature.projectzero.util.UserSession;
import com.revature.projectzero.util.exceptions.NoCoursesJoinedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class UserCoursesServiceTestSuite {

    // Instantiate system under test
    private UserCoursesService sut;

    // Mock dependencies required for the system under test
    private AppUser mockUser;   //not sure if i need this yet
    private UserSession mockUserSession;
    private UserCoursesRepository mockUserCourseRepo;

    @Before
    public void setup(){

        mockUserCourseRepo = mock(UserCoursesRepository.class);
        mockUserSession = mock(UserSession.class);
        mockUser = mock(AppUser.class);
        mockUser.setUsername("tester");
        mockUserSession.setCurrentUser(mockUser);
        sut = new UserCoursesService(mockUserCourseRepo,mockUserSession);
    }

    @After
    public void cleanUp(){
        mockUserCourseRepo = null;
        mockUserSession = null;
        sut = null;
    }

    @Test
    public void joinCourse_executesSuccessfully_whenGivenValidCourseName(){
        // Arrange
        String validCourse = "validCourseToJoin";
        List<String> validCourseList = new ArrayList<>();
        when(mockUserSession.getCurrentUser()).thenReturn(mockUser);
        when(mockUserCourseRepo.findRegisteredCoursesByUsername(mockUser.getUsername())).thenReturn(validCourseList);
        // Act
        sut.joinCourse(validCourse);
        // Assert
        verify(mockUserSession,times(1)).getCurrentUser();
        verify(mockUserCourseRepo,times(1)).findRegisteredCoursesByUsername(mockUser.getUsername());

    }

    @Test(expected = NoCoursesJoinedException.class)
    public void getCourses_throwsException_whenUser_hasNotRegistered_forAnyCourses(){
        // Arrange
        List<String> emptyCourseList = new ArrayList<>();
        when(mockUserSession.getCurrentUser()).thenReturn(mockUser);
        when(mockUserCourseRepo.findRegisteredCoursesByUsername(mockUser.getUsername())).thenReturn(emptyCourseList);
        // Act
        try{
            sut.getCourses();
        } finally { // Assert
            verify(mockUserSession,times(1)).getCurrentUser();
            verify(mockUserCourseRepo, times(1)).findRegisteredCoursesByUsername(mockUser.getUsername());
        }
    }




}





