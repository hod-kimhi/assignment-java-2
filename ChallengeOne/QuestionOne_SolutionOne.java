/*
Challenge 1, Question 1 - Algorithms

The findPairs function loops through the array once, storing the current value if it hasn't been used to make
a pair already or printing a pair if the current value matches one of the stored values to make a pair.

Comments and/or Possible sources of error:
- Should have a complexity of O(n) as the array is only looped through once
 */

import java.util.HashMap;
import java.util.Map;

public class QuestionOne_SolutionOne {

    final static int[] arr = {2, 4, 5, 1, 3, 5, 4};
    final static int sum = 6;

    public static void main(String[] args) {
        findPairs(arr, sum);
    }

    static void findPairs(int[] testArray, int targetSum) {
        Map<Integer, Integer> pairs = new HashMap<>();

        for (int currentNum : testArray) {
            if (pairs.containsKey(currentNum)) { //if key exists, then key + value = sum must exist, and we simply print out value (i) + key (sum - i)
                if (pairs.get(currentNum) != null) {
                    System.out.println("(" + currentNum + "," + (targetSum - currentNum) + ")");
                }

                // "use up" the current pair so it can't occur again by nulling both integers of the pair, essentially flagging it for no future use
                pairs.put(currentNum, null); //null current number
                pairs.put(targetSum - currentNum, null); //null the pair of current number

            } else if (!pairs.containsValue(currentNum)) { //if value does not exist, create key with current value where key (sum - i) + value (i) = sum
                pairs.put(targetSum-currentNum, currentNum);
            }
        }
    }
}