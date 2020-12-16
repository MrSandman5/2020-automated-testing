package org.safonov.mutation;

public class Example {

    private int invocationCount = 0;

    private static final double OFFSET = 1.0;
    private final double threshold;

    public Example(final double threshold) {
        this.threshold = threshold;
    }

    public boolean threshold(final double value) {
        logInvocation();
        return value >= threshold + OFFSET;
    }

    private void logInvocation() {
        invocationCount++;
    }

}