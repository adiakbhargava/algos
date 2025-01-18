package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringUniqueCharacters {
    public static void main(String[] args) {
        String str = "abwercba";
        System.out.println("String : " + str
        + "\nUnique Substring Count : " + (new LongestSubstringUniqueCharacters()).getLongestSubstringCount(str));

        str = "abcba";
        System.out.println("String : " + str
                + "\nUnique Substring Count : " + (new LongestSubstringUniqueCharacters()).getLongestSubstringCountHashSet(str));
    }

    private int getLongestSubstringCount(String str){
        // create a hashmap that will contain the most recent indexes of the characters in the string as we traverse through it with our sliding window
        HashMap<Character, Integer> prevIndexes = new HashMap<>();
        int l = 0;
        int r = 0;
        int len = str.length();
        // create a variable for the max length of the substring with unique elements
        int maxLength = 0;

        // traverse through string with our sliding window
        while(r < len){
            // check if the character r is already present in the window
            if(prevIndexes.containsKey(str.charAt(r))
            && prevIndexes.get(str.charAt(r)) >= l){ // we need to make sure that the index of the character is not out of scope for our window to prevent miscounting duplicates
                // if we know that the character already exists within our window, skip directly past the previous index of that character (prevents needing to constantly check if duplicate is still present in our window)
                l = prevIndexes.get(str.charAt(r)) + 1;
            }

            // get max length of substring
            maxLength = Math.max(maxLength, r - l + 1);
            // update previous index hashmap with current character
            prevIndexes.put(str.charAt(r), r);
            // increment right pointer
            r = r + 1;
        }

        return maxLength;
    }

    // Uses a hash set to find the longest substring with unique elements
    // Not as optimized as previous example due to needing to keep iterating through needing to keep updating window until duplicate is gone
    private int getLongestSubstringCountHashSet(String str){
        // create a hashset that will contain all unique characters in our string
        HashSet<Character> windowElements = new HashSet<>();
        int len = str.length();
        int maxLength = 0;
        int l = 0;
        int r = 0;

        // iterate through string with a dynamic sliding window
        while(r < len){
            while(windowElements.contains(str.charAt(r))){
                windowElements.remove(str.charAt(l));
                l = l + 1;
            }

            maxLength = Math.max(maxLength, r - l + 1);
            windowElements.add(str.charAt(r));
            r = r + 1;
        }

        return maxLength;
    }
}
