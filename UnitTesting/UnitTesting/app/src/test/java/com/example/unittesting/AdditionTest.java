package com.example.unittesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AdditionTest {
    int numberOne;
    int numberTwo;
    int expected;

    public AdditionTest(int numberOne,int numberTwo,int expected){
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.expected = expected;
    }

    @Test
    public void addNumbersTest(){
        // Arrange
        Utils util = new Utils();
        // Act
        int result = util.addNumbers(numberOne,numberTwo);
        // Assert
        assertEquals(expected,result);
    }

    @Parameterized.Parameters(name = "{index}:addNumbers({0},{1}={2}) ")
    public static Collection addParameter(){
        return Arrays.asList(new Object[][]{
                {0,1,1},
                {2,3,5},
                {6,7,1},
                {6,9,15}
        });
    }
}
