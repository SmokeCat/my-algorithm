package com.smoke.solution;

import java.util.Arrays;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        if(n < 1) return new int[][]{};
        
        int[][] res = new int[n][n];
        int num = 1;
        
        for(int layer = 0; layer < n+1 >> 1; layer++){
            int x = layer, y = layer;
            // -->
            while(y < n - layer){
                res[x][y++] = num++;
            }
            x++; y--;

        	// ↓
            if(x == n - layer) return res;
            while(x < n - layer){
                res[x++][y] = num++;
            }
            x--; y--;

        	// <---
            while(y >= layer){
                res[x][y--] = num++;
            }
            x--; y++;

        	// ↑
            while(x > layer){
                res[x--][y] = num++;
            }
        }
        return res;
    }
    
    /**
     *	测试Solution 59
     * 
     * @param args
     */
    public static void main(String[] args) {
		System.out.println("Test Solution 59:");
		
		Solution59 s59 = new Solution59();
		
		for(int i = 1; i < 5; i++){
			int[][] res = s59.generateMatrix(i);
			
			System.out.println("\nn = " + i + ":");
			for(int j = 0; j < i; j++){
				System.out.println(Arrays.toString(res[j]));
			}
		}
	}
}
