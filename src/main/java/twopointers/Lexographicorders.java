package twopointers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lexographicorders {
    public static void main(String[] args) {
        // case 1 : typical case
        String str = "abcedda";
        System.out.println("Original String : " + str +
                "\nModified String : " + (new Lexographicorders()).nextLexographicSequence(str));

        // case 2 : single character string
        str = "a";
        System.out.println("Original String : " + str +
                "\nModified String : " + (new Lexographicorders()).nextLexographicSequence(str));

        // case 3 : string with repeated character
        str = "aaaa";
        System.out.println("Original String : " + str +
                "\nModified String : " + (new Lexographicorders()).nextLexographicSequence(str));

        // case 4 : string with random pivot character
        str = "ynitsed";
        System.out.println("Original String : " + str +
                "\nModified String : " + (new Lexographicorders()).nextLexographicSequence(str));
    }

    private String nextLexographicSequence(String str){
        int n = str.length();
        char[] letters = str.toCharArray();
        int pivot = n-2;

        while(pivot >= 0 && letters[pivot] >= letters[pivot+1]){
            pivot -= 1;
        }

        if(pivot == -1){
            StringBuilder sb = new StringBuilder(str);

            return sb.reverse().toString();
        }

        int rightmostSuccessor = n-1;
        while(letters[rightmostSuccessor] <= letters[pivot]){
            rightmostSuccessor -= 1;
        }

        char temp = letters[rightmostSuccessor];
        letters[rightmostSuccessor] = letters[pivot];
        letters[pivot] = temp;

        List<Character> list = new String(letters).chars()
                .mapToObj(c-> (char) c)
                .collect(Collectors.toList());

        List<Character> subList = list.subList(pivot+1, n);
        Collections.reverse(subList);

        return list.stream().map(String::valueOf)
                .collect(Collectors.joining(""));

    }
}
