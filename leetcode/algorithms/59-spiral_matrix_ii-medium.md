# 59. 螺旋矩阵II
https://leetcode-cn.com/problems/spiral-matrix-ii/

## 题目描述

给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:
```
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```

## 题解

### 解决思路：

同#54

### 代码

java代码:
~~~ java
class Solution {
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
            
            if(x == n - layer) return res;
            while(x < n - layer){
                res[x++][y] = num++;
            }
            x--; y--;
            
            while(y >= layer){
                res[x][y--] = num++;
            }
            x--; y++;
            
            while(x > layer){
                res[x--][y] = num++;
            }
        }
        return res;
    }
} 
~~~

### 复杂度分析：

时间复杂度：$O(n^2)$

空间复杂度：$O(1)$

## 其他方法
