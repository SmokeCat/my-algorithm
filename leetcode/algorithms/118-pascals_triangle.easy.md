# 188. 杨辉三角
https://leetcode-cn.com/problems/pascals-triangle/

## 题目描述

给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
```
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

## 题解

### 解决思路：

每一行除第一个和最后一个元素，中间的第i个元素的值是上一行的第i-1和第i个元素之和。

### 代码

java代码:
~~~ java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>(numRows);
        if(numRows <= 0)    return pascalsTriangle;
        
        pascalsTriangle.add(new ArrayList<Integer>(1));
        pascalsTriangle.get(0).add(1);
        
        List<Integer> preRow = null;
        
        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            for(int j = 1; j < i ; j ++){
                row.add(preRow.get(j-1) + preRow.get(j));
            }
            row.add(1);
            pascalsTriangle.add(row);
            preRow = row;
        }
        
        return pascalsTriangle;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n^2)$

空间复杂度：$O(n)$
