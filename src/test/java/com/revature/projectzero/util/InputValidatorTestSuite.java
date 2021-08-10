package com.revature.projectzero.util;

import com.revature.projectzero.documents.AppUser;
import com.revature.projectzero.documents.Course;
import com.revature.projectzero.util.exceptions.*;

import org.junit.*;


public class InputValidatorTestSuite {

    private InputValidator sut;

    @Before
    public void setup(){
        sut = new InputValidator();
    }

    @After
    public void cleanUp(){
        sut = null;
    }


    // User Entry Validator Tests

    @Test
    public void userEntryValidator_returnsTrue_whenGivenValidUser(){
        // Arrange
        AppUser validUser = new AppUser("valid","valid","valid@email.com","valid5","valid-password",false);
        // Act
        sut.newUserEntryValidator(validUser);
        // Assert
        Assert.assertTrue(sut.newUserEntryValidator(validUser));

    }


    @Test(expected = InvalidEntryException.class)
    public void userEntryValidator_throwsException_whenGivenBlankValues(){
        // Arrange
        AppUser invalidUser = new AppUser("","","","","",false);

        // Act
        sut.newUserEntryValidator(invalidUser);

    }

    @Test(expected = InvalidUsernameException.class)
    public void userEntryValidator_throwsException_whenGivenInvalidUsernameUnderFourChars(){
        // Arrange
        AppUser invalidUser = new AppUser("valid","valid","valid@email.com","inv","valid-password",false);

        //Act
        sut.newUserEntryValidator(invalidUser);
    }

    @Test(expected = InvalidUsernameException.class)
    public void userEntryValidator_throwsException_whenGivenInvalidUsernameWithSymbols(){
        // Arrange
        AppUser invalidUser = new AppUser("valid","valid","valid@email.com","invalid!","valid-password",false);

        //Act
        sut.newUserEntryValidator(invalidUser);
    }

    @Test(expected = InvalidEmailException.class)
    public void userEntryValidator_throwsException_whenGivenInvalidEmail(){
        // Arrange
        AppUser invalidUser = new AppUser("valid","valid","invalid-email.com","valid","valid-password",false);
        // Act
        sut.newUserEntryValidator(invalidUser);
    }

    @Test(expected = InvalidPasswordException.class)
    public void userEntryValidator_throwsException_whenGivenInvalidPassword(){
        // Arrange
        AppUser invalidUser = new AppUser("valid","valid","valid@email.com","valid","invalid",false);
        // Act
        sut.newUserEntryValidator(invalidUser);
    }


    // Course Entry Validator Tests

    @Test
    public void newCourseEntryValidator_returnsTrue_whenGivenValidCourse(){
        // Arrange
        Course validCourse = new Course("ValidCourse","VLD101","This is a valid course.",true);

        // Act
        sut.newCourseEntryValidator(validCourse);

        //Assert
        Assert.assertTrue(sut.newCourseEntryValidator(validCourse));

    }

    @Test(expected = InvalidEntryException.class)
    public void newCourseEntryValidator_throwsException_whenGivenInvalidCourse_withBlankValues(){
        // Arrange
        Course invalidCourse = new Course("","","",true);

        // Act
        sut.newCourseEntryValidator(invalidCourse);
    }

    @Test(expected = InvalidCourseNameException.class)
    public void newCourseEntryValidator_throwsException_whenGivenInvalidCourseName_tooLong(){
        // Arrange
        Course invalidCourse = new Course("maaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaath",
                "MTH","This course name is too long.",true);

        // Act
        sut.newCourseEntryValidator(invalidCourse);
    }

    @Test(expected = InvalidCourseNameException.class)
    public void newCourseEntryValidator_throwsException_whenGivenInvalidCourseName_tooShort(){
        // Arrange
        Course invalidCourse = new Course("math","MTH101"
                ,"This course name is too short.",true);

        // Act
        sut.newCourseEntryValidator(invalidCourse);
    }

    @Test(expected = InvalidCourseAbbreviationException.class)
    public void newCourseEntryValidator_throwsException_whenGivenInvalidCourseAbbreviation(){
        // Arrange
        Course invalidCourse = new Course("Mathematics","Invalid"
                ,"This course abbreviation is too long.",true);

        // Act
        sut.newCourseEntryValidator(invalidCourse);
    }

    @Test(expected = InvalidCourseDescriptionException.class)
    public void newCourseEntryValidator_throwsException_whenGivenInvalidCourseDetail_tooShort(){
        // Arrange
        Course invalidCourse = new Course("Mathematics","MTH101"
                ,"Invalid",true);

        // Act
        sut.newCourseEntryValidator(invalidCourse);
    }

    @Test(expected = InvalidCourseDescriptionException.class)
    public void newCourseEntryValidator_throwsException_whenGivenInvalidCourseDetail_tooLong(){
        // Arrange
        Course invalidCourse = new Course("Mathematics","MTH101","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
                true);

        // Act
        sut.newCourseEntryValidator(invalidCourse);
    }

}




