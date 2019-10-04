# 35. 搜索插入位置
https://leetcode-cn.com/problems/search-insert-position/

## 题目描述

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:
```
输入: [1,3,5,6], 5
输出: 2
```

示例 2:
```
输入: [1,3,5,6], 2
输出: 1
```

示例 3:
```
输入: [1,3,5,6], 7
输出: 4
```

示例 4:
```
输入: [1,3,5,6], 0
输出: 0
```

## 题解

### 解决思路：

二分查找+判断插入索引

### 代码

java代码:
~~~ java
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        
        int pLeft = 0, pRight = nums.length - 1;
        int mid = (pLeft + pRight) / 2;

        
        while(pLeft < pRight){
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                pLeft = mid + 1;
            }else{
                pRight = mid;
            }
            
            mid = (pLeft + pRight) / 2;
        }
        
        if(target > nums[mid]){
            return mid + 1;
        }else{
            return mid;
        }
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(\log n)$

空间复杂度：$O(1)$
