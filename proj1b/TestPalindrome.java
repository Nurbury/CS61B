import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeLast();
        }
        assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class. */

    @Test
    public void TestPalindrome() {
        Assert.assertTrue(palindrome.isPalindrome("A"));
        Assert.assertFalse(palindrome.isPalindrome("Aa"));
        Assert.assertFalse(palindrome.isPalindrome("Arrow"));
        Assert.assertTrue(palindrome.isPalindrome("noon"));
        Assert.assertTrue(palindrome.isPalindrome("racecar"));

        Assert.assertTrue(palindrome.isPalindrome("noon",offByOne));

    }


}
