/**
 * Longest Common Subsequence Problem
 * This class provides a method to solve the longest common subsequence (LCS) problem,
 * which is to find the length of the longest common subsequence between two strings.
 * Authors: [Isaiah Ayres, Joseph Kabesha]
 */

public class LongestCommonSubsequence {

    /**
     * Method to calculate the length of the longest common subsequence (LCS) between two strings.
     * 
     * @param s1 The first input string.
     * @param s2 The second input string.
     * @return The length of the LCS between s1 and s2.
     */
    public static int lcsLength(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // Create a 2D array to store the lengths of LCS for each sub-problem
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match, increment LCS length by 1
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Characters don't match, take the maximum LCS length from the previous cells
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the length of LCS for the entire strings s1 and s2
        return dp[m][n];
    }

    /**
     * Method to retrieve the longest common subsequence (LCS) between two strings.
     * 
     * @param s1 The first input string.
     * @param s2 The second input string.
     * @return The LCS between s1 and s2.
     */
    public static String getLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        StringBuilder lcs = new StringBuilder();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Trace back to construct the LCS
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int lcsLength = lcsLength(s1, s2);
        String lcs = getLCS(s1, s2);
        System.out.println("Input: s1 = \"" + s1 + "\", s2 = \"" + s2 + "\"");
        System.out.println("Output: LCS length = " + lcsLength + ", LCS = \"" + lcs + "\""); // Expected output: 4, "GTAB"

        String s3 = "ABCBDAB";
        String s4 = "BDCABB";
        lcsLength = lcsLength(s3, s4);
        lcs = getLCS(s3, s4);
        System.out.println("\nInput: s1 = \"" + s3 + "\", s2 = \"" + s4 + "\"");
        System.out.println("Output: LCS length = " + lcsLength + ", LCS = \"" + lcs + "\""); // Expected output: 4, "BCAB"
    }
}
