package com.chrystian.interviews;

public class NumOfIslandsGridDFS {
    
    public int numIslands(char[][] grid) { 
        int count = 0;
        if(grid.length <= 0)
            return count;

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int k = 0; k < n; k++){
                if(grid[i][k] == '1'){
                    count++;
                    spread(grid, i, k);
                }
            }
        }

        return count;
    }

    private void spread(char[][]grid, int i, int k){
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || k < 0 || k >= n)
            return;
        else if(grid[i][k] != '1')
            return;
        else{
            grid[i][k] = '2';
            spread(grid, i+1, k);
            spread(grid, i-1, k);
            spread(grid, i, k+1);
            spread(grid, i, k-1);
        }
    }
}
