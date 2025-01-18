package dynamicprogramming;

public class MatrixPathways {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println("Number of pathways of a " + m + " x " + n + " matrix (Unoptimized) is : " + (new MatrixPathways()).matrixPathways(m, n));

        m = 4;
        n = 4;
        System.out.println("Number of pathways of a " + m + " x " + n + " matrix (Unoptimized) is : " + (new MatrixPathways()).matrixPathways(m, n));

        System.out.println("Number of pathways of a " + m + " x " + n + " matrix (Optimized) is : " + (new MatrixPathways()).matrixPathwaysOptimized(m, n));

        m = 3;
        n = 3;
        System.out.println("Number of pathways of a " + m + " x " + n + " matrix (Optimized) is : " + (new MatrixPathways()).matrixPathwaysOptimized(m, n));
    }

    private int matrixPathways(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int j = 0; j < m; j++){
            dp[j][0] = 1;
        }

        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }

        return dp[m-1][n-1];
    }

    private int matrixPathwaysOptimized(int m, int n){
        int[] prevRow = new int[n];
        for(int i = 0; i < n; i++){
            prevRow[i] = 1;
        }

        for(int r = 1; r < m; r++){
            int[] currRow = new int[n];
            currRow[0] = 1;
            for(int c = 1;  c < n; c++){
                currRow[c] = prevRow[c] + currRow[c-1];
            }

            prevRow = currRow;
        }

        return prevRow[n-1];
    }
}
