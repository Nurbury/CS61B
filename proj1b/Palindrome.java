
/*
 *@title Palindrome
 *@author NorBury
 *@version 1.0
 *@create 2024/7/9 16:56
 *@description
 */


import org.junit.Assert;

public class Palindrome {


    public static Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> Deque = new LinkedListDeque<>();
//        Deque.addFirst(word);
        char[] c = word.toCharArray();
        for (char i :
                c) {
            Deque.addFirst(i);
        }
        return Deque;
    }

    public static boolean isPalindrome(String word) {
        Deque<Character> Deque = wordToDeque(word);
        if (compareEle(Deque)) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> Deque = wordToDeque(word);
        if (compareEle(Deque)) {
            return true;
        }
        return false;
    }
    private static boolean compareEle(Deque deque) {
        boolean res = true;
        while (deque.size() > 1) {
            // get the first item and the last item
            Character c1 = (Character) deque.removeLast();
            Character c2 = (Character) deque.removeFirst();
            if ((c1.compareTo(c2)) != 0) {
                res = false;
                break;
            }
        }
        return res;
    }
    private static boolean compareEle(Deque deque,CharacterComparator cc) {
        boolean res = true;
        while (deque.size() > 1) {
            // get the first item and the last item
            Character c1 = (Character) deque.removeLast();
            Character c2 = (Character) deque.removeFirst();
            if (!cc.equalChars(c1,c2)) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        isPalindrome("recocer");
        isPalindrome("worrow");
        isPalindrome("wordbrow");
        Assert.assertEquals(false,isPalindrome("wordbrow"));
        Assert.assertEquals(true,isPalindrome("A"));
        Assert.assertEquals(false,isPalindrome("Aa"));
        Assert.assertEquals(true,isPalindrome("worrow"));
        Assert.assertTrue(isPalindrome("A"));

    }


}
