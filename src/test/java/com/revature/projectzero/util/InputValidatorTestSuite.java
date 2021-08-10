package com.revature.projectzero.util;

import com.revature.projectzero.documents.AppUser;
import com.revature.projectzero.util.exceptions.InvalidEmailException;
import com.revature.projectzero.util.exceptions.InvalidEntryException;

import com.revature.projectzero.util.exceptions.InvalidPasswordException;
import com.revature.projectzero.util.exceptions.InvalidUsernameException;
import org.junit.*;


import static org.mockito.Mockito.*;


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


    @Test
    public void userEntryValidator_returnsTrue_whenGivenValidUser(){
        // Arrange
        AppUser validUser = new AppUser("valid","valid","valid@email.com","valid5","valid-password",false);
        // Act
        sut.userEntryValidator(validUser);
        // Assert
        Assert.assertTrue(sut.userEntryValidator(validUser));

    }


    @Test(expected = InvalidEntryException.class)
    public void userEntryValidator_throwsException_whenGivenBlankValues(){
        // Arrange
        AppUser invalidUser = new AppUser("","","","","",false);

        // Act
        sut.userEntryValidator(invalidUser);

    }

    @Test(expected = InvalidUsernameException.class)
    public void userEntryValidator_throwsException_whenGivenInvalidUsernameUnderFourChars(){
        // Arrange
        AppUser invalidUser = new AppUser("valid","valid","valid@email.com","inv","valid-password",false);

        //Act
        sut.userEntryValidator(invalidUser);
    }

    @Test(expected = InvalidUsernameException.class)
    public void userEntryValidator_throwsException_whenGivenInvalidUsernameWithSymbols(){
        // Arrange
        AppUser invalidUser = new AppUser("valid","valid","valid@email.com","invalid!","valid-password",false);

        //Act
        sut.userEntryValidator(invalidUser);
    }

    @Test(expected = InvalidEmailException.class)
    public void userEntryValidator_throwsException_whenGivenInvalidEmail(){
        // Arrange
        AppUser invalidUser = new AppUser("valid","valid","invalid-email.com","valid","valid-password",false);
        // Act
        sut.userEntryValidator(invalidUser);
    }

    @Test(expected = InvalidPasswordException.class)
    public void userEntryValidator_throwsException_whenGivenInvalidPassword(){
        // Arrange
        AppUser invalidUser = new AppUser("valid","valid","valid@email.com","valid","invalid",false);
        // Act
        sut.userEntryValidator(invalidUser);
    }

}




