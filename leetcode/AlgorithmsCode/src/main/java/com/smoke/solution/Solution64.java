package com.smoke.solution;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int sum = 0;
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 && j==0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j] + grid[i][j-1];
                else if(j == 0) grid[i][j] = grid[i][j] + grid[i-1][j];
                else grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        
        return grid[m-1][n-1];
    }
    
    /**
     *	测试Solution 64
     * 
     * @param args
     */
    public static void main(String[] args) {
		System.out.println("Test Solution 64:");
		
		Solution64 s64 = new Solution64();
		
//		int[][] grid = new int[][]{{1,2},{1,1}};
		int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
		
		System.out.println(s64.minPathSum(grid));
		
	}
}
