/**
 * This class has Palindrome related functions including string to deque conversion and palindrome identification.
 */

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        int wordLength = word.length();
        Deque<Character> wordDeque =  new ArrayDeque<Character>();
        for (int i = (wordLength - 1); i >= 0; i--) {
            wordDeque.addFirst(word.charAt(i));
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque);
    }

    private boolean isPalindromeHelper(Deque<Character> d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (d.removeFirst() == d.removeLast()) {
            return isPalindromeHelper(d);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        int u = 0;
        int d = (word.length() - 1);
        char first = word.charAt(u);
        char last = word.charAt(d);
        if (cc.equalChars(first, last)) {
            return isPalindrome(word.substring(u + 1, d), cc);
        }
        return false;
    }
}

