package greedy;

import java.util.Arrays;

public class Candies {
    public static void main(String[] args) {
        int[] ratings = {2, 3, 4, 2};
        System.out.println("Student Ratings : " + Arrays.toString(ratings));
        System.out.println("Total Amount of Candy Given : " + (new Candies()).giveCandies(ratings));
    }

    private int giveCandies(int[] studentRatings) {
        // 1. Init
        int len = studentRatings.length;
        int[] candies = new int[len];
        // set minimum amount of candies a student can get to 1
        for (int i = 0; i < len; i++) {
            candies[i] = 1;
        }

        // 2. Logic Impl
        // going from left to right, check if current student has a higher rating than the previous student
        // if so, set current student's candy amount to 1 more than the previous student
        for (int j = 1; j < len; j++) {
            if (studentRatings[j] > studentRatings[j - 1]) {
                candies[j] = candies[j - 1] + 1;
            }
        }

        // going from right to left, check if current student has higher rating than the student right after them
        // if so, set current student's candy amount to the max between the current student and the student right after them
        for (int x = len - 2; x >= 0; x--) {
            if (studentRatings[x] > studentRatings[x + 1]) {
                candies[x] = Math.max(candies[x], candies[x + 1] + 1);
            }
        }

        // return total sum of candies
        return Arrays.stream(candies).sum();
    }
}
