package com.example.unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

///Without parameter
public class UtilsTest {

    @Test
    public void isEven_numericcheck_odd() {
        // Arrange
        Utils util = new Utils();
        // Act
        boolean isOk = util.isEven(5);
        // Assert
        assertEquals(false,isOk);

    }

    @Test
    public void isEven_numericcheck_even() {
        // Arrange
        Utils util = new Utils();
        // Act
        boolean isOk = util.isEven(6);
        // Assert
        assertEquals(true,isOk);

    }

    @Test
    public void isInteger_is_a_integer() {
        // Arrange
        Utils util = new Utils();
        // Act
        boolean isOk = util.isInteger("5");
        // Assert
        assertEquals(false,isOk);
    }

    @Test
    public void isInteger_is_a_string() {
        // Arrange
        Utils util = new Utils();
        // Act
        boolean isOk = util.isInteger("Sjdfajlf");
        // Assert
        assertEquals(true,isOk);
    }
}