/*
Challenge 1, Question 1 - Algorithms

Firstly, the findPairs function sorts the array. Then, the function keeps two indexes, one at the start and one at the end
of the array. Every cycle we check if the current sum is greater or less than the target sum.
- If less, increase lower index so that the next sum will be greater than the current sum
- If greater, decrease the higher index, so that the next sum will be less than the current sum
Then we check again the new sum against the target sum and repeat the process until the indexes overlap, indicating that
we've crossed halfway through the array and that no more solutions are present.

Comments and/or Possible sources of error:
- Array must be sorted, adding to the overall complexity
 */

import java.util.Arrays;

public class QuestionOne_SolutionTwo {

    final static int[] testArray = {2, 4, 5, 1, 3, 5, 4};
    final static int targetSum = 6;

    public static void main(String[] args) {
        findPairs(testArray, targetSum);
    }

    static void findPairs(int[] testArray, int targetSum) {
        Arrays.sort(testArray);

        int lowerIndex = 0;
        int higherIndex = testArray.length - 1;

        while (lowerIndex < higherIndex) {
            if (testArray[lowerIndex] + testArray[higherIndex] == targetSum) {
                System.out.println("("+ testArray[lowerIndex] + "," + testArray[higherIndex] + ")");
            }

            if (testArray[lowerIndex] + testArray[higherIndex] > targetSum) {
                higherIndex--;
            }
            else { //increase if we are below the sum
                lowerIndex++;
            }
        }
    }
}