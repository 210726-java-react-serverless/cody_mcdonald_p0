package com.revature.projectzero.services;

import com.revature.projectzero.documents.AppUser;
import com.revature.projectzero.repositories.UserRepository;
import com.revature.projectzero.util.InputValidator;
import com.revature.projectzero.util.UserSession;
import com.revature.projectzero.util.exceptions.InvalidEntryException;
import com.revature.projectzero.util.exceptions.ResourcePersistenceException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.mockito.Mockito.*;

public class UserServiceTestSuite {

    // Instantiate objects used for test
    private UserService sut;
    private UserRepository mockUserRepo;
    private UserSession mockSession;
    private InputValidator mockValidator;

    // Initialize objects before each test
    @Before
    public void setup(){

        mockUserRepo = mock(UserRepository.class);
        mockSession = mock(UserSession.class);
        mockValidator = mock(InputValidator.class);
        sut = new UserService( mockUserRepo, mockSession, mockValidator);

    }

    // Clear out objects after each test by setting them to null and letting garbage collection do the rest
    @After
    public void cleanUp(){
        mockUserRepo = null;
        mockSession = null;
        sut = null;
    }


    @Test
    public void registerReturnsSuccessfullyWhenGivenValidUser(){
        //Arrange
        AppUser expectedResult = new AppUser("test", "test", "te.st@test.test", "test", "test.test",false);
        AppUser validUser = new AppUser("test", "test", "te.st@test.test", "test", "test.test",false);
        when(mockValidator.userEntryValidator(validUser)).thenReturn(true);
        when(mockUserRepo.findUserByUsername(anyString())).thenReturn(null);
        when(mockUserRepo.findUserByEmail(anyString())).thenReturn(null);
        when(mockUserRepo.save(validUser)).thenReturn(expectedResult);

        //Assert
        AppUser actualResult = sut.register(validUser);

        //Act
        Assert.assertEquals(expectedResult,actualResult);
        verify(mockValidator,times(1)).userEntryValidator(validUser);
        verify(mockUserRepo,times(1)).findUserByUsername(anyString());
        verify(mockUserRepo,times(1)).findUserByEmail(anyString());
        verify(mockUserRepo,times(1)).save(validUser);

    }

    @Test(expected = ResourcePersistenceException.class)
    public void register_throwsException_whenGivenUserWithDuplicateUsername() {

        // Arrange
        AppUser existingUser = new AppUser("original", "original", "original", "duplicate", "original",false);
        AppUser duplicate = new AppUser("first", "last", "email", "duplicate", "password",false);
        when(mockUserRepo.findUserByUsername(duplicate.getUsername())).thenReturn(existingUser);

        // Act
        try {
            sut.register(duplicate);
        } finally {
            // Assert
            verify(mockUserRepo, times(1)).findUserByUsername(duplicate.getUsername());
            verify(mockUserRepo, times(0)).save(duplicate);
        }

    }

    @Test(expected = ResourcePersistenceException.class)
    public void register_throwsException_whenGivenUserWithDuplicateEmail() {

        // Arrange
        AppUser existingUser = new AppUser("original", "original", "duplicate", "original", "original",false);
        AppUser duplicate = new AppUser("first", "last", "duplicate", "username", "password",false);
        when(mockUserRepo.findUserByUsername(duplicate.getUsername())).thenReturn(existingUser);

        // Act
        try {
            sut.register(duplicate);
        } finally {
            // Assert
            verify(mockUserRepo, times(1)).findUserByUsername(duplicate.getUsername());
            verify(mockUserRepo, times(0)).save(duplicate);
        }

    }

    @Test(expected = InvalidEntryException.class)
    public void registerThrowsExceptionWhenGivenUserWithBlankValues(){
        //Arrange
        AppUser invalidUser = new AppUser("","","","","",false);
        when(mockValidator.userEntryValidator(invalidUser)).thenThrow(InvalidEntryException.class);

        //Act
        try{
            sut.register(invalidUser);
        } finally{
            // Assert
            verify(mockValidator, times(1)).userEntryValidator(invalidUser);
            verify(mockUserRepo, times(0)).save(invalidUser);
        }

    }


}
