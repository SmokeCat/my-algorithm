package com.smoke.solution;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m = matrix.length;
    	if (m == 0) return false;
    	int n = matrix[0].length;
    	if(n == 0) return false;
    	
    	int x = 0, y = n - 1;
    	
    	while(x < m){
    		if(matrix[x][y] == target) return true;
    		else if(matrix[x][y] > target) break;
    		++x;
    	}
    	
    	if(x == m) return false;
    	
    	while(y >= 0){
    		if(matrix[x][y] == target) return true;
    		else if(matrix[x][y] < target) return false;
    		--y;
    	}
    	
    	return false;
    }
}
