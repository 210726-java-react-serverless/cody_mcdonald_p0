package com.revature.projectzero.services;

import com.revature.projectzero.documents.AppUser;
import com.revature.projectzero.repositories.UserRepository;
import com.revature.projectzero.util.UserSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class UserServiceTestSuite {


    private UserService sut;
    private UserRepository mockUserRepo;
    private UserSession mockSession;

    @Before
    public void setup(){

        mockUserRepo = mock(UserRepository.class);
        mockSession = mock(UserSession.class);
        sut = new UserService( mockUserRepo, mockSession);

    }

    @After
    public void cleanUp(){
        mockUserRepo = null;
        mockSession = null;
        sut = null;
    }

    @Test
    public void registerReturnsSuccessfullyWhenGivenValidUser(){
        //Arrange
        AppUser expectedResult = new AppUser("test", "test", "test", "test", "test",false);
        AppUser validUser = new AppUser("test", "test", "test", "test", "test",false);
        when(mockUserRepo.findUserByUsername(anyString())).thenReturn(null);
        when(mockUserRepo.findUserByEmail(anyString())).thenReturn(null);
        when(mockUserRepo.save(validUser)).thenReturn(expectedResult);

        //Assert
        AppUser actualResult = sut.register(validUser);


        //Act
        Assert.assertEquals(expectedResult,actualResult);
        verify(mockUserRepo,times(1)).findUserByUsername(anyString());
        verify(mockUserRepo,times(1)).findUserByEmail(anyString());
        verify(mockUserRepo,times(1)).save(validUser);

    }


}
