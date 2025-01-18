package graphs;

public class CountIslands {
    public static void main(String[] args) {
        int[][] sea  = {
                {1,1,0,0},
                {1,1,0,0},
                {0,0,1,1},
                {1,0,0,1}
        };
        System.out.println("Sea : ");
        (new CountIslands()).printSea(sea);
        System.out.println("Traversed Sea : ");
        int count = (new CountIslands()).countIslands(sea);
        (new CountIslands()).printSea(sea);
        System.out.println("Number of Islands : " + count);


    }

    private int countIslands(int[][] sea){
        // if the sea is null, return 0
        if(sea == null){
            return 0;
        }

        // traverse through sea and if land is found, perform a dfs to find all the other bits of land surronding it
        int count = 0;
        for(int r = 0; r < sea.length; r++){
            for(int c = 0; c < sea[0].length; c++){
                if(sea[r][c] == 1){
                    dfs(r,c,sea);
                    count += 1;
                }
            }
        }

        return count;
    }

    private void dfs(int r, int c, int[][] sea){
        // set land to -1 (indicates we visited it)
        sea[r][c] = -1;
        // define directions for which we will explore neighbors of our current position
        int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // if land is found, perform another dfs
        for(int[] d : direction){
            int nextR = r + d[0];
            int nextC = c + d[1];
            // checking updated positions are within bounds of the sea and that the new position is land
            if(isWithinBounds(nextR, nextC, sea) && sea[nextR][nextC] == 1){
                dfs(nextR, nextC, sea);
            }
        }
    }

    private boolean isWithinBounds(int r, int c, int[][] sea){
        return 0 <= r && r < sea.length && 0 <= c && c < sea[0].length;
    }

    private void printSea(int[][] sea){
        for (int r = 0; r < sea.length; r++) {
            for (int c = 0; c < sea[r].length; c++) {
                System.out.print(sea[r][c] + " ");
            }
            System.out.println();
        }
    }
}
