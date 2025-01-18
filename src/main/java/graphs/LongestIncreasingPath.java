package graphs;

public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,8},
                {3,4,4},
                {7,9,2}
        };
        System.out.println("Matrix : ");
        (new LongestIncreasingPath()).printMatrix(matrix);
        System.out.println("Longest Path : " + (new LongestIncreasingPath()).longestIncreasingPath(matrix));
    }

    private int longestIncreasingPath(int[][] matrix){
        if(matrix == null){
            return 0;
        }
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                result = Math.max(result, dfs(r,c,matrix,memo));
            }
        }

        return result;
    }

    private int dfs(int r, int c, int[][] matrix, int[][] memo){
        // 1. Init
        if(memo[r][c] != 0){
            return memo[r][c];
        }
        int maxPath = 1;
        // establish directions
        int[][] directions = {
                {-1,0},
                {1,0},
                {0,-1},
                {0,1}
        };

        // get path
        for(int[] d : directions){
            int nextR = r + d[0];
            int nextC = c + d[1];
            if(isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] > matrix[r][c]){
                maxPath = Math.max(maxPath, 1 + dfs(nextR, nextC, matrix, memo));
            }
        }
        // add path to 'memory'
        memo[r][c] = maxPath;

        return maxPath;
    }

    private boolean isWithinBounds(int r, int c, int[][] sea){
        return 0 <= r && r < sea.length && 0 <= c && c < sea[0].length;
    }

    private void printMatrix(int[][] matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
