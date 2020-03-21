import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalindrome() {
        // Odd palindrome
        boolean expected = true;
        String input = "tacocat";
        boolean actual = palindrome.isPalindrome(input);
        assertEquals(expected, actual);

        // Even palindrome
        expected = true;
        input = "anna";
        actual = palindrome.isPalindrome(input);
        assertEquals(expected, actual);

        // False, not a palindrome
        expected = false;
        input = "Palindrome";
        actual = palindrome.isPalindrome(input);
        assertEquals(expected, actual);

        // Single letter palindrome
        expected = true;
        input = "a";
        actual = palindrome.isPalindrome(input);
        assertEquals(expected, actual);

        // Null
        expected = false;
        input = null;
        actual = palindrome.isPalindrome(input);
        assertEquals(expected, actual);

        // Empty space
        expected = true;
        input = " ";
        actual = palindrome.isPalindrome(input);
        assertEquals(expected, actual);


    }

    @Test
    public void testPalindromeCC() {
        // Odd  obo palindrome
        boolean expected = true;
        String input = "flake";
        boolean actual = palindrome.isPalindrome(input, TestOffByOne.offByOne);
        assertEquals(expected, actual);


        // False
        expected = false;
        input = "Palindrome";
        actual = palindrome.isPalindrome(input, TestOffByOne.offByOne);
        assertEquals(expected, actual);
    }
}
