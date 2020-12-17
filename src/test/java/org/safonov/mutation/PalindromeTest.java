package org.safonov.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {

    @Test
    public void empty() {
        final Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome(""));
    }

    /*@Test
    public void single() {
        final PalindromeService palindromeTester = new PalindromeService();
        assertTrue(palindromeTester.isPalindrome("a"));
    }*/

    @Test
    public void palindrome() {
        final Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome("noon"));
    }

    @Test
    public void almostPalindrome() {
        final Palindrome palindromeTester = new Palindrome();
        assertFalse(palindromeTester.isPalindrome("neon"));
    }

    @Test
    public void notPalindrome() {
        final Palindrome palindromeTester = new Palindrome();
        assertFalse(palindromeTester.isPalindrome("box"));
    }

}
