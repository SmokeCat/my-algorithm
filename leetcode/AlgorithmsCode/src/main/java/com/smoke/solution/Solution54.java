package com.smoke.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        // 行数
        int m = matrix.length;
        if(m == 0) return res;
        // 列数
        int n = matrix[0].length;
        if(n == 0) return res;
        
        for(int layer = 0; layer < Math.min(m, n) + 1 >> 1; layer++){
        	int x = layer, y = layer;
        	// --->
        	while(y < n - layer){
        		res.add(matrix[x][y++]);
        	}
        	// ↓
        	++x; --y;
            if(x == m - layer) break;
        	while(x < m - layer){
        		res.add(matrix[x++][y]);
        	}
        	--x; --y;
        	// <---
            if(y == layer - 1) break;
        	while(y >= layer){
        		res.add(matrix[x][y--]);
        	}
        	--x; ++y;
        	// ↑
        	while(x > layer){
        		res.add(matrix[x--][y]);
        	}
        }
        
        
        return res;
    }	
    
    /**
     *	测试Solution 54
     * 
     * @param args
     */
    public static void main(String[] args) {
		System.out.println("Test Solution 54:");
		
		Solution54 s54 = new Solution54();
		
		int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] matrix3 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		int[][] matrix4 = {};

		System.out.println(Arrays.toString(s54.spiralOrder(matrix1).toArray()));
		System.out.println(Arrays.toString(s54.spiralOrder(matrix2).toArray()));
		System.out.println(Arrays.toString(s54.spiralOrder(matrix3).toArray()));
		System.out.println(Arrays.toString(s54.spiralOrder(matrix4).toArray()));
		
		
	}
}
