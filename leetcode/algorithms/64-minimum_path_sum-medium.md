# 64. 最短路径和
https://leetcode-cn.com/problems/minimum-path-sum/

## 题目描述

给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:
```
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
```

## 题解

### 解决思路：

动态规划，在grid[i][j]中保存到达当前点的路径的最小和。

其中，grid[i][j] = grid[i][j] + min(grid[i-1][j], grid[i][j-1])。

第一行的就是grid[i][j] = grid[i][j] + gird[i][j-1]

第一列grid[i][j] = grid[i][j] + gird[i-1][j]

### 代码

java代码:
~~~ java
class Solution {
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
}
~~~

### 复杂度分析：

时间复杂度：$O(mn)$

空间复杂度：$O(1)$
