package com.smoke.solution;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m = matrix.length;
    	if (m == 0) return false;
    	int n = matrix[0].length;
    	if(n == 0) return false;
    	
    	int x = 0, y = n - 1;
    	while(y >= 0 && x < m){
    		
			if(matrix[x][y] == target) return true;
			else if(matrix[x][y] > target) --y;
			else ++x;
    	}
    	
    	return false;
    }
}
