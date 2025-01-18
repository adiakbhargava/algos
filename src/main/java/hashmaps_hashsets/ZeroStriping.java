package hashmaps_hashsets;

import java.util.Arrays;

public class ZeroStriping {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5},
                {6,0,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,0}
        };
        printMatrix(matrix);
        (new ZeroStriping()).zeroStriping(matrix);
        printMatrix(matrix);
    }

    private void zeroStriping(int[][] matrix){
        // 1. get row and col length
        int n = matrix.length;
        int m = matrix[0].length;
        // 2. initialize zero flags for first row and col to indicate if they need to be zero-striped
        boolean firstRowZeroFlag = false;
        boolean firstColZeroFlag = false;

        // 3. set zero-striping flags for first row and first col
        // check if zero is present in first row, if yes, set zero-striping flag to true
        for(int c = 0; c < m; c++){
            if(matrix[0][c] == 0){
                firstRowZeroFlag = true;
            }
        }
        // check if zero is present in first col, if yes, set zero-striping flag to true
        for(int r = 0; r < n; r++){
            if(matrix[r][0] == 0){
                firstColZeroFlag = true;
            }
        }

        // 4. set zero-striping flags for inner matrix (i.e excluding first row and first col), first row and first col will be used for storing zero-striping flags for inner matrix
        // iterate through sub-matrix (starting at index 1,1) and set corresponding zero-striping flags
        for(int r = 1; r < n; r++){
            for(int c = 1; c < m; c++){
                if(matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // 5. start striping
        // iterate through inner matrix and set elements to zero if first row or first col has a zero in its corresponding index
        for(int r = 1; r < n; r++){
            for(int c = 1; c < m; c++){
                if(matrix[r][0] == 0 || matrix[0][c] == 0){
                    matrix[r][c] = 0;
                }
            }
        }

        // 6. stripe first row if zero flag is true
        if(firstRowZeroFlag){
            for(int c = 0; c < m; c++){
                matrix[0][c] = 0;
            }
        }

        // stripe first col if zero flag is true
        if(firstColZeroFlag){
            for(int r = 0; r < n; r++){
                matrix[r][0] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix){
        // Using nested for loops
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

}
