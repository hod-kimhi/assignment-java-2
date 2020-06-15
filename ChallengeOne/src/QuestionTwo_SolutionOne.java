/*
Challenge 1, Question 2 - Is Palindrome?

The isPalindrome function checks if a given string is a palindrome (a word or phrase which is the same when read backwards)
The function begins by removing

The findPairs function loops through the array once, storing the current value if it hasn't been used to make
a pair already or printing a pair if the current value matches one of the stored values to make a pair.

Comments and/or Possible sources of error:
- More efficient than using the reverse() method of String Builder.
- Gives user the option to include digits, whitespace, punctuation, or check in a case sensitive manner.
 */

public class QuestionTwo_SolutionOne {

    final static String[] strings = {"A car, a man, a maraca.", "Radar", "bOb", "bobette", "hello world", "rAcecAr", "A lad named E. Mandala", "evitative"};

    //User options if they wish to expand or limit their definition of a palindrome
    final static boolean includeDigits = false;
    final static boolean includeWhitespace = false;
    final static boolean includePunctuation = false;
    final static boolean caseSensitive = false;

    public static void main(String[] args) {
        for(String string : strings) {
            if(isPalindrome(string)) {
                System.out.println(string + " is a palindrome");
            } else {
                System.out.println(string + " is not a palindrome");
            }
        }
    }

    static boolean isPalindrome(String testString) {
        if(!includeDigits) {
            testString = testString.replaceAll("[\\d]", "");
        }

        if(!includeWhitespace) {
            testString = testString.replaceAll("[\\s]", "");
        }

        if(!includePunctuation) {
            testString = testString.replaceAll("\\p{Punct}", "");
        }

        if(!caseSensitive) {
            testString = testString.toLowerCase();
        }

        int length = testString.length();
        for (int i = 0; i < (length / 2); i++) {
            if (testString.charAt(i) != testString.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
