package CodeTop;

import java.util.Arrays;

/**
 * AlexzyChu
 * 2021/10/8 11:21
 * <p>
 * Descripition 最长回文字串
 */
public class Solu5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (boolean[] row : dp)
            Arrays.fill(row, true);
        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j)
                    continue;
                dp[j][i] = dp[j + 1][i - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        int max = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j]) {
                    if (max < j - i + 1){
                        max = j - i  +1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }
}
