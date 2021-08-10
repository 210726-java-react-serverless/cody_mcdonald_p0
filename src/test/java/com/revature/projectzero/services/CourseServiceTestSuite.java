package com.revature.projectzero.services;

import com.revature.projectzero.documents.Course;
import com.revature.projectzero.repositories.CourseRepository;
import com.revature.projectzero.util.InputValidator;
import com.revature.projectzero.util.exceptions.InvalidEntryException;
import com.revature.projectzero.util.exceptions.ResourcePersistenceException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class CourseServiceTestSuite {

    // Instantiate system under test
    private CourseService sut;

    // Mock dependencies required for the system under test
    private CourseRepository mockCourseRepo;
    private InputValidator mockValidator;

    @Before
    public void setup(){

        mockCourseRepo = mock(CourseRepository.class);
        mockValidator = mock(InputValidator.class);
        sut = new CourseService(mockCourseRepo, mockValidator);

    }

    @After
    public void cleanUp(){
        mockCourseRepo = null;
        mockValidator = null;
        sut = null;
    }


    @Test
    public void add_returnsSuccessfully_whenGivenValidCourse(){
        //Arrange
        Course expectedResult = new Course("ValidCourse","VLDCS",
                "This is a valid course description",true);
        Course validCourse = new Course("ValidCourse","VLDCS",
                "This is a valid course description",true);
        when(mockValidator.newCourseEntryValidator(validCourse)).thenReturn(true);
        when(mockCourseRepo.findCourseByName(anyString())).thenReturn(null);
        when(mockCourseRepo.findCourseByAbbreviation(anyString())).thenReturn(null);
        when(mockCourseRepo.save(validCourse)).thenReturn(expectedResult);

        //Act
        Course actualResult = sut.add(validCourse);

        //Assert
        Assert.assertEquals(expectedResult,actualResult);
        verify(mockValidator,times(1)).newCourseEntryValidator(validCourse);
        verify(mockCourseRepo,times(1)).findCourseByName(anyString());
        verify(mockCourseRepo,times(1)).findCourseByAbbreviation(anyString());
        verify(mockCourseRepo,times(1)).save(validCourse);

    }

    @Test(expected = ResourcePersistenceException.class)
    public void add_throwsException_whenGivenCourse_withDuplicateCourseName(){
        //Arrange
        Course existingCourse = new Course("Duplicate","ORGNL",
                "Original course.",true);
        Course duplicate = new Course("Duplicate","TEST",
                "This course has a duplicate name",true);
        when(mockCourseRepo.findCourseByName(duplicate.getCourseName())).thenReturn(existingCourse);

        //Act
        try {
            sut.add(duplicate);
        }finally {

            //Assert
            verify(mockCourseRepo, times(1)).findCourseByName(duplicate.getCourseName());
            verify(mockCourseRepo, times(0)).save(duplicate);
        }

    }

    @Test(expected = ResourcePersistenceException.class)
    public void add_throwsException_whenGivenCourse_withDuplicateCourseAbbreviation(){
        //Arrange
        Course existingCourse = new Course("Original","DUPE",
                "Original course.",true);
        Course duplicate = new Course("Tester","DUPE",
                "This course has a duplicate abbreviation",true);
        when(mockCourseRepo.findCourseByAbbreviation(duplicate.getCourseAbbreviation())).thenReturn(existingCourse);

        //Act
        try {
            sut.add(duplicate);
        }finally {

            //Assert
            verify(mockCourseRepo, times(1))
                    .findCourseByAbbreviation(duplicate.getCourseAbbreviation());
            verify(mockCourseRepo, times(0)).save(duplicate);
        }

    }

    @Test(expected = InvalidEntryException.class)
    public void add_throwsException_whenGivenCourse_withEmptyValues(){
        //Arrange
        Course invalidCourse = new Course("","","",true);
        when(mockValidator.newCourseEntryValidator(invalidCourse)).thenThrow(InvalidEntryException.class);
        //Act
        try {
            sut.add(invalidCourse);
        }finally { //Assert
            verify(mockValidator,times(1)).newCourseEntryValidator(invalidCourse);
        }


    }




}
