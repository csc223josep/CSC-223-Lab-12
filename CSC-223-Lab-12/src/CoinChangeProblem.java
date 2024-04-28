import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Coin Change Problem
 * This class provides a method to solve the coin change problem, which is to find the minimum number of coins needed to make up a given amount.
 * Authors: Joseph Kabesha, Isaiah Ayres
 */
public class CoinChangeProblem {

    /**
     * Finds the minimum number of coins needed to make up a given amount using the specified denominations of coins.
     * @param coins an array of integers representing the denominations of the coins
     * @param amount the total amount to make up with the coins
     * @return a list of integers representing the coins used to make up the amount, or an empty list if it's not possible
     */
    public static List<Integer> minCoins(int[] coins, int amount) {
        // Create an array to store the minimum number of coins needed for each amount
        int[] dp = new int[amount + 1];
        // Create a list to store the coins used for each amount
        List<List<Integer>> coinList = new ArrayList<>();
        for (int i = 0; i <= amount; i++) {
            coinList.add(new ArrayList<>());
        }

        // Initialize dp array with a large value representing infinity
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;

        // Iterate through each amount from 1 to the target amount
        for (int i = 1; i <= amount; i++) {
            // Iterate through each coin denomination
            for (int coin : coins) {
                // If the current coin denomination can be used to make the amount i
                if (coin <= i && dp[i - coin] + 1 < dp[i]) {
                    // Update dp[i] to the minimum of its current value and 1 + dp[i - coin]
                    dp[i] = 1 + dp[i - coin];
                    // Update coinList[i] with the coins used for the current amount
                    coinList.set(i, new ArrayList<>(coinList.get(i - coin)));
                    coinList.get(i).add(coin);
                }
            }
        }

        // If dp[amount] is still the initial high value, it means it's impossible to make the amount
        if (dp[amount] > amount) {
            return Collections.emptyList();
        } else {
            // Otherwise, return the minimum number of coins needed for the amount and the list of coins used
            return coinList.get(amount);
        }
    }

    /**
     * Main method to test the minCoins function with different scenarios.
     * @param args the command-line arguments (unused)
     */
    public static void main(String[] args) {
        // Test cases
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Test Case 1:");
        System.out.println("Input: coins = " + Arrays.toString(coins1) + ", amount = " + amount1);
        List<Integer> coinsUsed1 = minCoins(coins1, amount1);
        System.out.println("Output: " + (coinsUsed1.isEmpty() ? -1 : coinsUsed1.size() + " coins used: " + coinsUsed1));

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("\nTest Case 2:");
        System.out.println("Input: coins = " + Arrays.toString(coins2) + ", amount = " + amount2);
        List<Integer> coinsUsed2 = minCoins(coins2, amount2);
        System.out.println("Output: " + (coinsUsed2.isEmpty() ? -1 : coinsUsed2.size() + " coins used: " + coinsUsed2));

        int[] coins3 = {2};
        int amount3 = 1;
        System.out.println("\nTest Case 3:");
        System.out.println("Input: coins = " + Arrays.toString(coins3) + ", amount = " + amount3);
        List<Integer> coinsUsed3 = minCoins(coins3, amount3);
        System.out.println("Output: " + (coinsUsed3.isEmpty() ? -1 : coinsUsed3.size() + " coins used: " + coinsUsed3));
    }
}
