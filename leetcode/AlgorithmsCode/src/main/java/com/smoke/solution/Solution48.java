package com.smoke.solution;

public class Solution48 {
    public void rotate(int[][] matrix) {
    	int n = matrix[0].length;
        if(n < 2) return ;
        
        for(int i = 0; i < n >> 1; i++){
        	for(int j = i; j < n-i-1; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
        	}
        }
    }
}
