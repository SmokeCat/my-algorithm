# 1. 两数之和
https://leetcode-cn.com/problems/two-sum/

## 题目描述

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

## 题解

### 我的方法：

嵌套循环遍历，查找两个相加等于target的元素。

~~~ java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
~~~

#### 复杂度分析：

时间复杂度：$O(n^2)$

空间复杂度：$O(1)$