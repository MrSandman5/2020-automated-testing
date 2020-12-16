package org.safonov.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    @Test
    public void testThreshold() {
        final Example classToTest = new Example(10.0);

        assertTrue(classToTest.threshold(11.0));
        assertFalse(classToTest.threshold(10.0));
    }
}
