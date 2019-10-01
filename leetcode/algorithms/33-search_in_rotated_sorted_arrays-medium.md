# 33. 搜索旋转排序数组
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

## 题目描述

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 $O(\log n)$ 级别。

示例 1:
```
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
```

示例 2:
```
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
```

## 题解

### 解决思路：

二分法，左指针指向数组头部，右指针指向数组右部，因为是旋转数组，可以分为左右两个有序数组。

中间指针有两种状态，一种是落在左有序数组，一种是落在右有序数组。

关键在于二分查找时左右指针移动的判断条件。

可以根据不同的条件分类。

TODO: 图解

### 代码

java代码:
~~~ java
class Solution {
    public int search(int[] nums, int target) {
          if (nums==null||nums.length==0){
            return -1;
        }
  int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // 当[0,mid]有序时,向后规约条件
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                lo = mid + 1;
                // 当[0,mid]发生旋转时，向后规约条件
            } else if (target > nums[mid] && target < nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return  nums[lo] == target ? lo : -1;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(\log n)$

空间复杂度：$O(1)$

## 其他方法

### 思路：

先找到两个有序数组的分界线，左右指针第一次移动到分界线后剩下的就是有序数组的二分查找。
