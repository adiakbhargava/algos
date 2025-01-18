package dynamicprogramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    private int longestCommonSubstring(String s1, String s2){
        int[][] dp = new int[s2.length() + 1][s1.length() + 1];
        for(int i = s1.length()-1; i >= 0; i--){
            for(int j = s2.length()-1; j >= 0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }

    private int longestCommonSubstringOptimized(String s1, String s2){
        int[] prevRow = new int[s2.length() + 1];
        for(int i = s1.length() - 1; i >= 0; i--){
            int[] currRow =  new int[s2.length() + 1];
            for(int j = s2.length()-1; j > 0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    currRow[j] = 1 + prevRow[j+1];
                } else{
                    currRow[j] = Math.max(prevRow[j], currRow[j+1]);
                }
            }
            prevRow = currRow;
        }

        return prevRow[0];
    }
}
