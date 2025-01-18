package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;

public class SubstringAnagrams {
    public static void main(String[] args) {
        String str = "caabab";
        String anagram = "aba";
        System.out.println("String : " + str
        + "\nAnagram : " + anagram
        + "\nAnagram Count : " + (new SubstringAnagrams()).getAnagramCount(str, anagram));

        str = "caabab";
        anagram = "aba";
        System.out.println("\nString : " + str
                + "\nAnagram : " + anagram
                + "\nAnagram Count : " + (new SubstringAnagrams()).getAnagramCountHashMap(str, anagram));
    }

    private int getAnagramCount(String str, String anagram){
        // 1. Input Validation
        int strLength = str.length();
        int anagramLength = anagram.length();
        // check to make sure anagrams can be derived from string (length of anagram has to be less than the string it is deriving from)
        if(strLength < anagramLength){
            return 0;
        }

        // 2. Init
        // create two arrays representing the expected frequencies of characters in the anagram along with the frequencies present in the sliding window
        int[] expectedFrequencies = new int[26];
        int[] windowFrequencies = new int[26];
        // populate expectedFrequencies with the number of occurences of each character in the anagram
        // System.out.println("UNICODE OF a : " + (int)('a'));
        // System.out.println("UNICODE OF b : " + (int)('b'));
        for(char c : anagram.toCharArray()){
            expectedFrequencies[((int)(c)) - ((int)'a')] += 1;
        }

        // 3. Logic Impl
        int l = 0;
        int r = 0;
        int count = 0;
        while(r < strLength){
            // add frequency of character to windowFrequencies
            windowFrequencies[((int)str.charAt(r)) - ((int)'a')] += 1;
            // check if window is same size as anagram
            if(r - l + 1 == anagramLength){
                // if yes, check if frequency counts of characters match
                if(Arrays.equals(expectedFrequencies,windowFrequencies)){
                    // increment count if match found
                    count++;
                }
                // decrement frequency of leftmost character in sliding window as we slide to next character
                windowFrequencies[((int)str.charAt(l))-((int)'a')] -= 1;
                l++;
            }
            r++;
        }

        return count;
    }

    // Uses hashmap for storing characters and frequency counts, space is O(N)
    private int getAnagramCountHashMap(String str, String anagram){
        // 1. input validation
        // get lengths of string and anagram and check to see that string is longer than anagram
        int strLength = str.length();
        int anagramLength = anagram.length();
        if(strLength < anagramLength){
            return 0;
        }

        // 2. Init
        int count = 0;//result
        // create hashmaps to store expected frequencies of characters from the anagram
        HashMap<Character, Integer> expectedFrequencies = new HashMap<>();
        // create hashmap to store character frequencies of current window
        HashMap<Character, Integer> windowFrequencies = new HashMap<>();
        // store frequencies of anagram into expectedFrequencies HashMap
        for(char c : anagram.toCharArray()){
            expectedFrequencies.put(c, expectedFrequencies.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;

        //3. logic Implementation
        // iterate through string with fixed window size of anagramLength
        while(r < strLength){
            // store character into window frequencies HashMap and increment count
            windowFrequencies.put(str.charAt(r), windowFrequencies.getOrDefault(str.charAt(r), 0) + 1);
            // check if window is expanded to anagramLength
            if(r - l + 1 == anagramLength){
                // if yes, check if the window hashmap matches with the anagram hashmap
                if(expectedFrequencies.equals(windowFrequencies)){
                    // increment count if match is found
                    count = count + 1;
                }

                // decrement leftmost character frequency, if frequency is 0, remove key-value pair from hashmap
                if(windowFrequencies.get(str.charAt(l)) - 1 == 0){
                    windowFrequencies.remove(str.charAt(l));
                } else {
                    // decrement frequency normally
                    windowFrequencies.put(str.charAt(l), windowFrequencies.get(str.charAt(l)) - 1);
                }
                l++;
            }
            r++;
        }

        return count;
    }
}
