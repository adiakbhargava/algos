package binarysearch;

public class MatrixSearch {
    public static void main(String[] args) {
        int target = 27;
        int[][] matrix = {
                {2, 3, 4, 6},
                {7,10,11,17},
                {20,21,24,33}
        };
        System.out.println((new MatrixSearch()).search(matrix, target));
    }

    private boolean search(int[][] matrix, int target){
        // 1. Init
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        // set right equal to the last index of matrix if it were a single array
        int right = m*n-1;
        // 2. Logic Impl
        while(left <= right){
            int mid = (left + right) / 2;
            // obtain corresponding row and column indices for mid
            int r = mid / n;
            int c = mid % n;

            // if indexed element is equal to target, return true
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] < target){
                // else if indexed element is less than target, move left pointer one to the right of mid
                left = mid + 1;
            } else{
                // else if indexed element is greater than target, move right pointer one to the left of mid
                right = mid - 1;
            }
        }

        // return false if element is not contained in matrix
        return false;
    }
}
