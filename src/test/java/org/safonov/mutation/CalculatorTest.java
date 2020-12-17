package org.safonov.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    @Test
    public void positiveNoMutation() {
        final Calculator obj = new Calculator();
        assertTrue(obj.isPositive(10));
        assertFalse(obj.isPositive(0));
    }

    @Test
    public void positiveMutation() {
        final Calculator obj = new Calculator();
        assertTrue(obj.isPositiveMutation(10));
        assertTrue(obj.isPositiveMutation(0));
    }
}
