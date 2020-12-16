package org.safonov.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorServiceTest {

    @Test
    public void positiveNoMutation() {
        final CalculatorService obj = new CalculatorService();
        assertTrue(obj.isPositive(10));
        assertFalse(obj.isPositive(0));
    }

    @Test
    public void positiveMutation() {
        final CalculatorService obj = new CalculatorService();
        assertTrue(obj.isPositiveMutation(10));
        assertTrue(obj.isPositiveMutation(0));
    }
}
