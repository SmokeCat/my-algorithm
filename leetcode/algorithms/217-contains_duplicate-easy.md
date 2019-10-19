# 1. 两数之和
https://leetcode-cn.com/problems/contains-duplicate/

## 题目描述

给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:
```
输入: [1,2,3,1]
输出: true
```

示例 2:
```
输入: [1,2,3,4]
输出: false
```

示例 3:
```
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
```

## 题解

### 解决思路：

使用Hash存放数值，如果已经包含返回true

### 代码

java代码:
~~~ java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2) return false;
        Set<Integer> set = new HashSet<>(nums.length*4);
        for(Integer num : nums){
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }
        return false;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(n)$

## 其他方法1

### 思路

先排序，然后顺序遍历查重

### 代码

java代码:
~~~ java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2) return false;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i])    return true;
        }
        return false;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(1)$
