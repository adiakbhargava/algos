package hashmaps_hashsets;

import java.util.HashMap;
import java.util.HashSet;

public class VerifySudokuBoard {
    public static void main(String[] args) {
        int[][] testGrid = {
                {3, 0, 6, 0, 5, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {1, 0, 2, 5, 0, 0, 3, 2, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {0, 3, 0, 0, 0, 8, 2, 5, 0},
                {0, 1, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 0, 0, 0}};
        System.out.println((new VerifySudokuBoard()).verifySudokuBoard(testGrid));

    }

    private boolean verifySudokuBoard(int[][] board) {
        // setup set of 9 hash sets for columns
        HashMap<Integer, HashSet<Integer>> colSets = new HashMap<>();
        // setup 3x3 grid of hash sets for the 9 subgrids
        HashSet<Integer>[][] subGridSets = new HashSet[3][3];
        // initialize all hash sets in subgrid array
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                subGridSets[r][c] = new HashSet<>();
            }
        }

        // iteratre through rows
        for (int r = 0; r < board.length; r++) {
            // setup a rowset for checking duplicate values
            HashSet<Integer> rowSet = new HashSet<Integer>();
            // iterate through the columns
            for (int c = 0; c < board[0].length; c++) {
                // get corresponding column and subgrid set
                HashSet<Integer> colSet = colSets.computeIfAbsent(c, k -> new HashSet<Integer>());
                HashSet<Integer> subGridSet = subGridSets[r/3][c/3];
                // skip blank spaces (0), check
                if (board[r][c] == 0) {
                    continue;
                } else if (rowSet.contains(board[r][c]) || colSet.contains(board[r][c])
                || subGridSet.contains(board[r][c])) {
                    System.out.println("row : " + r + " col : " + c + " val : " + board[r][c]);

                    return false;
                }

                colSet.add(board[r][c]);
                rowSet.add(board[r][c]);
                subGridSet.add(board[r][c]);
            }
        }

        return true;
    }

    private boolean verifySudokuBoardOG(int[][] board) {
        HashMap<Integer, HashSet<Integer>> rowSets = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> colSets = new HashMap<>();

        HashSet<Integer>[][] subGridSets = new HashSet[3][3];
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                subGridSets[r][c] = new HashSet<>();
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                HashSet<Integer> rowSet = rowSets.computeIfAbsent(r, k -> new HashSet<Integer>());
                HashSet<Integer> colSet = colSets.computeIfAbsent(c, k -> new HashSet<Integer>());
                HashSet<Integer> subGridSet = subGridSets[r/3][c/3];
                if (board[r][c] == 0) {
                    continue;
                } else if (rowSet.contains(board[r][c]) || colSet.contains(board[r][c])
                        || subGridSet.contains(board[r][c])) {
                    System.out.println("row : " + r + " col : " + c + " val : " + board[r][c]);

                    return false;
                }

                colSet.add(board[r][c]);
                rowSet.add(board[r][c]);
                subGridSet.add(board[r][c]);
            }
        }

        return true;
    }
}
