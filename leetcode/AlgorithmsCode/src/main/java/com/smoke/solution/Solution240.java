package com.smoke.solution;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m = matrix.length;
    	if (m == 0) return false;
    	int n = matrix[0].length;
    	if(n == 0) return false;
    	
    	for(int y = n - 1; y >= 0; y--){
    		int x = 0;
    		
    		for(; x < m; x++){
    			if(matrix[x][y] == target) return true;
    			else if(matrix[x][y] > target) break;
    		}
    	}
    	
    	return false;
    }
}
