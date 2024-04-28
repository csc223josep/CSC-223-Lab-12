import java.util.Arrays;

/**
 * Robbery Problem
 * This class provides a method to solve the robbery problem, which is to find the
 * maximum amount of money that can be robbed without robbing any two adjacent
 * houses.
 * Authors: Joseph Kabesha, Isaiah Ayres
 */

public class RobberyProblem {

    /**
     * Method to calculate the maximum amount of money that can be robbed without
     * robbing any two adjacent houses.
     * 
     * @param houseMoney An array representing the amount of money in each house.
     * @return The maximum amount of money that can be robbed.
     */
    public static int robMax(int[] houseMoney) {
        int n = houseMoney.length;
        // If there are no houses, return 0
        if (n == 0)
            return 0;
        // If there's only one house, return the money in that house
        if (n == 1)
            return houseMoney[0];
        // Create an array to store the maximum amount of money that can be robbed up
        // to each house
        int[] dp = new int[n + 1];
        // Base case: No money can be robbed from zero houses
        dp[0] = 0;
        // When there's only one house, the maximum amount robbed is its value
        dp[1] = houseMoney[0];
        // Iterate through each house starting from the second house
        for (int i = 2; i <= n; i++) {
            // Compute the maximum money by making a choice:
            // Either rob the current house and add the value of the house to dp[i-2]
            // Or do not rob the current house and carry forward the value of dp[i-1]
            dp[i] = Math.max(houseMoney[i - 1] + dp[i - 2], dp[i - 1]);
        }
        // Return the maximum amount of money that can be robbed considering all houses
        return dp[n];
    }

    public static void main(String[] args) {
        // Test cases
        int[] houseMoney1 = {2, 3, 2};
        System.out.println("Test Case 1:");
        System.out.println("Input: houseMoney = " + Arrays.toString(houseMoney1));
        int result1 = robMax(houseMoney1);
        System.out.println("Output: Maximum amount robbed = " + result1);

        int[] houseMoney2 = {5, 1, 2, 10, 6};
        System.out.println("\nTest Case 2:");
        System.out.println("Input: houseMoney = " + Arrays.toString(houseMoney2));
        int result2 = robMax(houseMoney2);
        System.out.println("Output: Maximum amount robbed = " + result2);

        int[] houseMoney3 = {1, 7, 3, 4, 9, 2};
        System.out.println("\nTest Case 3:");
        System.out.println("Input: houseMoney = " + Arrays.toString(houseMoney3));
        int result3 = robMax(houseMoney3);
        System.out.println("Output: Maximum amount robbed = " + result3);
    }
}
