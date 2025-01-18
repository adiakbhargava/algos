package dynamicprogramming;

public class LongestPalindromeString {
    public static void main(String[] args) {

    }

    private String longestPalindromeInString(String str){
        int n = str.length();
        if(n == 0){
            return "";
        }
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int startIndex = 0;
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        for(int i = 0; i < n-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                dp[i][i+1] = true;
                maxLen = 2;
                startIndex = i;
            }
        }
        for(int substringLen = 3; substringLen < n + 1; substringLen++){
            for(int i = 0; i < n-substringLen+1; i++){
                int j = i + substringLen - 1;
                if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    maxLen = substringLen;
                    startIndex = i;
                }
            }
        }

        return str.substring(startIndex, startIndex+maxLen);
    }

    private String longestPalindromeInStringOptimized(String str){
        int n = str.length();
        int start = 0;
        int maxLen = 0;
        for(int center = 0; center < n; center++){
            int oddStart = expandPalindrome(center, center, str)[0];
            int oddLength = expandPalindrome(center, center, str)[1];
            if(oddLength > maxLen){
                start = oddStart;
                maxLen = oddLength;
            }
            if(center < n - 1 && str.charAt(center) == str.charAt(center + 1)){
                int evenStart = expandPalindrome(center, center+1, str)[0];
                int evenLength = expandPalindrome(center, center+1, str)[1];
                if(evenLength > maxLen){
                    start = evenStart;
                    maxLen = evenLength;
                }
            }
        }

        return str.substring(start, start + maxLen);
    }

    private int[] expandPalindrome(int left, int right, String str){
        while(left > 0 && right < str.length() - 1 && str.charAt(left-1) == str.charAt(right+1)){
            left -= 1;
            right += 1;
        }

        return new int[]{left, right-left+1};
    }
}
