package com.example.unittesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@RunWith(value = Parameterized.class)
public class ParameterTest {

    int lnumber = 0;
    boolean lboolean ;

    public ParameterTest(int number,boolean expected){
       this.lnumber = number;
       this.lboolean = expected;
    }


    @Test
    public void isEvenCheck(){
        // Arrange
        Utils util = new Utils();
        // Act
        boolean isOk = util.isEven(this.lnumber);
        // Assert
        assertEquals(this.lboolean,isOk);
    }



    @Parameterized.Parameters(name = "{index}: isEven({0}) = {1}")
    public static Collection evenNumbers(){
        return Arrays.asList(new Object[][]{
                {4,true},
                {5,false},
                {9,false},
                {10,true}
        });
    }


}
