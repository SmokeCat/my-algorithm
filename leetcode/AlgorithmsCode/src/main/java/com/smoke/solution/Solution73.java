package com.smoke.solution;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        if(n == 0) return;
        
        // 第一列的标志位
        int flag = 1;
        
        
        // 第一次遍历，设置标志位
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(j == 0) flag = 0;
                    else matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // 根据标志位将矩阵置零
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(flag == 0){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
