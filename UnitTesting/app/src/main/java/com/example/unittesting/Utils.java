package com.example.unittesting;

public class Utils {

    public boolean isEven(int number)
    {
        if(number % 2 == 0) {
            return true;
        }
        return false;

    }

    public boolean isInteger(String number){
        try {
            Integer.parseInt(number);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public int addNumbers(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

}
