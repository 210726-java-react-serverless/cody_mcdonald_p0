package com.revature.Project_0.util;

import com.revature.Project_0.exceptions.InvalidEntryException;
import org.junit.*;



public class inputValidatorTestSuite {


    @Before
    public void beforeEachTest(){}
    @After
    public void afterEachTest(){}

    @Test(expected = InvalidEntryException.class)
    public void userEntryValidator_throwsException_whenGivenBlankValues(){

        Assert.assertThrows(InvalidEntryException.class,() -> {
            inputValidator.userEntryValidator("","","","","");
        });
    }

}




