# 88. 合并两个有序数组
https://leetcode-cn.com/problems/merge-sorted-array/

## 题目描述

给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

* 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
* 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:
```
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
```

## 题解

### 解决思路：

避免搬移nums1的数据，可以从nums1的末尾开始赋值。从大的开始比较。

### 代码

java代码:
~~~ java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m - 1, j = n - 1, ptr = nums1.length - 1; ptr >= 0;){
            if(j < 0 || i >= 0 && nums1[i] >= nums2[j]){
                nums1[ptr--] = nums1[i--];
            }else{
                nums1[ptr--] = nums2[j--];
            }
        }
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(1)$

## 其他方法
