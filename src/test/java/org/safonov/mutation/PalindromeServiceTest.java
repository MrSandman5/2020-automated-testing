package org.safonov.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeServiceTest {

    @Test
    public void empty() {
        final PalindromeService palindromeTester = new PalindromeService();
        assertTrue(palindromeTester.isPalindrome(""));
    }

    /*@Test
    public void single() {
        final PalindromeService palindromeTester = new PalindromeService();
        assertTrue(palindromeTester.isPalindrome("a"));
    }*/

    @Test
    public void palindrome() {
        final PalindromeService palindromeTester = new PalindromeService();
        assertTrue(palindromeTester.isPalindrome("noon"));
    }

    @Test
    public void almostPalindrome() {
        final PalindromeService palindromeTester = new PalindromeService();
        assertFalse(palindromeTester.isPalindrome("neon"));
    }

    @Test
    public void notPalindrome() {
        final PalindromeService palindromeTester = new PalindromeService();
        assertFalse(palindromeTester.isPalindrome("box"));
    }

}
