package twopointers;

public class Validpalindrome {
    public static void main(String[] args) {
        // case 1 : case with non-alphanumeric charactes
        String str = "a+2c!2a";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));

        // case 2 : case with only alphanumeric characters
        str = "abba";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));

        // case 3 : empty string
        str = "";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));

        // case 4 : single-element string
        str = "a";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));

        // case 5 : two-element string with same characters
        str = "aa";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));

        // case 6 : two-element strign with different characters
        str = "ab";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));

        // case 7 : only non-alphanumeric characters
        str = "!, (?)";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));

        // case 8 : date
        str = "12.02.2021";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));

        // case 9 : date that's not a palindrome
        str = "21.02.2021";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));

        // case 10 : string that is not a palindrome
        str = "hello, world!";
        System.out.println((new Validpalindrome()).isValidPalindrome(str));
    }

    public boolean isValidPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;
        str = str.toLowerCase();

        while (l < r) {
            while (!isAlpha(str.charAt(l)) && (l < r)) {
                l++;
            }

            while(!isAlpha(str.charAt(r)) && (l < r)){
                r--;
            }

            if(!(l < r)){
                break;
            }

            if(str.charAt(l) != str.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    private static boolean isAlpha(Character c){
        if(c == null){
            return false;
        }

        return Character.isLetterOrDigit(c);
    }
}
