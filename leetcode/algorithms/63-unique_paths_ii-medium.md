# 63. 不同路径II
https://leetcode-cn.com/problems/unique-paths-ii/

## 题目描述

一个机器人位于一个 m x n 网格的左上角。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角

网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:
```
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
```

## 题解

### 解决思路：

动态规划，每一个格子保存到达当前格子的路径数，其中第一行和第一列为1，其他的路径数等于左边格子和上边格子路径数之和。

### 代码

java代码:
~~~ java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) return 0;
        
        obstacleGrid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        
        for(int i = 1; i < n; i++){
        	obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i-1];
        }
        
        for(int i = 1; i < m; i++){
        	obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i-1][0];
        }
        
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		obstacleGrid[i][j] =obstacleGrid[i][j]==1 ? 0 : obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
        	}
        }
        return obstacleGrid[m-1][n-1];
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(mn)$

空间复杂度：$O(1)$
