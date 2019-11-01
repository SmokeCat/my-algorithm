# 74. 搜索二维矩阵
https://leetcode-cn.com/problems/search-a-2d-matrix/

## 题目描述

编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

示例 1:
```
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
```

示例 2:
```
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false
```

## 题解

### 解决思路：

从右上角开始搜索，先向下，再向左。

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
~~~

### 复杂度分析：

时间复杂度：$O(m+n)$

空间复杂度：$O(1)$

## 其他方法1

### 思路

看作长度为m*n的一维数组，二分查找。

### 代码

java代码:
~~~ java

~~~

### 复杂度分析：

时间复杂度：$O(\log(mn))$

空间复杂度：$O(1)$
