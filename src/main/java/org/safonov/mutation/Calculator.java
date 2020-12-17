package org.safonov.mutation;

public class Calculator {

    public boolean isPositiveMutation(final int number) {
        boolean result = false;
        if (number >= 0) {
            result = true;
        }
        return result;
    }

    public boolean isPositive(final int number) {
        boolean result = false;
        if (number > 0) {
            result = true;
        }
        return result;
    }

}