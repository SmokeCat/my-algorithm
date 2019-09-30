# 1. 两数之和
https://leetcode-cn.com/problems/two-sum/

## 题目描述

实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
```
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```

## 题解

### 解决思路：

寻找最后最长逆序数组。

处理



TODO: 图解

### 代码

java代码:
~~~ java
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len < 3){
            reverse(nums, 0);
            return ;
        }
        
        int tmp;
        int i = len - 3, k = len - 1;  // k == end
        
        // 当k-1 < k时，
        if(nums[k-1] < nums[k]){
            reverse(nums, k - 1);
            return;
        }
        
        // 当k-1 > k时
        //寻找第后一个不是反序的数字
        while(i >= 0 && nums[i] >= nums[i+1]){i--;}
        
        if(i >= 0){
            // 将[i+1, k]中最小的大于nums[i]的数字和nums[i]交换
            int p = len - 1;
            
            while(nums[p] <= nums[i]){p--;}
            
            tmp = nums[i];
            nums[i] = nums[p];
            nums[p] = tmp;
            
        }

        // 此时[i+1,k]是倒序排列
        reverse(nums, i + 1);
        
        return;
    }
    
    public void reverse(int[] nums, int start){
        int tmp, end = nums.length - 1;
        while(start < end){
            tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(1)$
