package slidingwindow;

import java.util.HashMap;

public class LongestUniformSubstringReplacements {
    public static void main(String[] args) {
        String str = "aabcdcca";
        int k = 2;
        System.out.println("String : " + str
        + "\nLongest Substring While Replacing " + k + " Character(s) : "
        + (new LongestUniformSubstringReplacements()).getLongestUniformSubstringAfterReplacement(str, k));
    }

    private int getLongestUniformSubstringAfterReplacement(String str, int k){
        // create a hashmap of frequencies for each character we come across
        HashMap<Character, Integer> freq = new HashMap<>();
        int len = str.length();
        // create a variable representing the max length of the substring we can get
        int maxLength = 0;
        // create a variable for the highest frequency of characters that appear in our sliding window
        int highestFrequency = 0;
        int l = 0;
        int r = 0;

        // traverse through the string using a dynamic sliding window
        while (r < len){
            // put the character into frequency hashmap
            freq.put(str.charAt(r), freq.getOrDefault(str.charAt(r), 0)+1);
            // find the highest frequency after putting character into map
            highestFrequency = Math.max(highestFrequency, freq.get(str.charAt(r)));

            // get the number of characters needed to be replaced in our current substring (length of sliding window - highest frequency)
            int numCharsToReplace = (r - l + 1) - highestFrequency;
            // if the number of characters to replace is greater than k, slide the window by one character
            if(numCharsToReplace > k){
                // decrement the frequency of the left character by 1 as we leave it
                freq.put(str.charAt(l), freq.get(str.charAt(l))-1);
                // increment the left pointer
                l = l + 1;
            }

            // get the current 'max length' of the window (we don't need to do Math.max since the length of the current window increases or stays the same)
            maxLength = r - l + 1;
            // increment right pointer
            r = r + 1;
        }

        return maxLength;
    }
}
