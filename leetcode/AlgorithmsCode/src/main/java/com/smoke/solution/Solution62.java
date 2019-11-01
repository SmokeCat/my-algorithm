package com.smoke.solution;

public class Solution62 {
    public int uniquePaths(int m, int n) {
    	if(m == 0 || n == 0) return 0;
    	else if(n == 1 || m == 1) return 1;
    	
    	int[][] paths = new int[m][n];
    	
    	for(int i = 0; i < m; i++){
    		for(int j = 0; j < n; j++){
    			if(i == 0 || j == 0){
    				paths[i][j] = 1;
    			}else{
    				paths[i][j] = paths[i-1][j] + paths[i][j-1];
    			}
    		}
    	}
    	
		return paths[m-1][n-1];
    }
    
    // 优化空间复杂度为O(n)
    public int uniquePaths2(int m, int n) {
    	if(m == 0 || n == 0) return 0;
    	else if(n == 1 || m == 1) return 1;
        
        int[] paths = new int[n];
        
        for(int i=0; i < n; i++){
            paths[i] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                paths[j] += paths[j-1];
            }
        }
    	
		return paths[n-1];
    }
}
