package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class MatrixInfection {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1,0},
                {0,0,2,1},
                {0,1,1,0}
        };
        System.out.println("Original Matrix : ");
        (new MatrixInfection()).printMatrix(matrix);
        System.out.println("Number of seconds for infection to spread : " + (new MatrixInfection()).matrixInfection(matrix));
        System.out.println("Infected Matrix : ");
        (new MatrixInfection()).printMatrix(matrix);

        int[][] strandedMatrix = {
                {1,2,1},
                {0,0,0},
                {1,0,0}
        };
        System.out.println("Original Matrix : ");
        (new MatrixInfection()).printMatrix(strandedMatrix);
        System.out.println("Number of seconds for infection to spread : " + (new MatrixInfection()).matrixInfection(strandedMatrix));
        System.out.println("Infected Matrix : ");
        (new MatrixInfection()).printMatrix(strandedMatrix);



    }

    private int matrixInfection(int[][] matrix){
        // define directions that we will use to explore our matrix
        int[][] directions = {
                {-1,0},
                {1,0},
                {0,-1},
                {0,1}
        };
        // establish a queue that keeps track of the infected nodes
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        int numberOfOnes = 0;
        int timeInSeconds = 0;

        // keep track of number of uninfected and infected nodes
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(matrix[r][c] == 1){
                    // keep track of number of ones (or uninfected nodes) in the matrix
                    numberOfOnes += 1;
                } else if(matrix[r][c] == 2){
                    // add indices of infected nodes to the queue
                    queue.add(Arrays.asList(r,c));
                }
            }
        }

        while(!queue.isEmpty() && numberOfOnes > 0){
            // each layer for which the infection spreads increases the time by 1 second
            timeInSeconds += 1;
            // get current length of queue
            int currLengthOfQueue =  queue.size();
            // iterate through current queue of infected nodes
            for(int i = 0; i < currLengthOfQueue; i++){
                // get matrix indices of infected node
                List<Integer> matrixIndices = queue.removeFirst();
                // check if surrounding nodes are uninfected
                for(int[] d : directions){
                    int nextR = matrixIndices.get(0) + d[0];
                    int nextC = matrixIndices.get(1) + d[1];
                    // make sure new indices are within the bounds of the matrix
                    if(isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] == 1){
                        // set uninfected node to infected
                        matrix[nextR][nextC] = 2;
                        // decrease number of uninfected nodes in matrix by one
                        numberOfOnes -= 1;
                        // add newly infected node to queue
                        queue.add(Arrays.asList(nextR,nextC));
                    }
                }
            }
        }

        // if the number of ones left in the matrix is 0, we know we infected the entire matrix, otherwise, there is still an uninfected node left
        return (numberOfOnes == 0 ? timeInSeconds : -1);
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
