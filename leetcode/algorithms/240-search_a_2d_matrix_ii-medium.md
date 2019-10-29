# 240. 搜索二维矩阵II
https://leetcode-cn.com/problems/search-a-2d-matrix-ii/

## 题目描述

编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

示例:
```
现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

## 题解

### 解决思路：

从右上角开始搜索，向左下角缩减。

### 代码

java代码:
~~~ java
class Solution {
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
~~~

### 复杂度分析：

时间复杂度：$O(m+n)$

空间复杂度：$O(1)$