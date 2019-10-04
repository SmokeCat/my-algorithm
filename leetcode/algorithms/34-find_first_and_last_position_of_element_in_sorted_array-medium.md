# 34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

## 题目描述

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:
```
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
```

示例 2:
```
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
```

## 题解

### 解决思路：

先二分查找找到target，然后再分别用二分查找找到左边界索引和右边界索引。

### 代码

java代码:
~~~ java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        
        if(nums.length < 1) return res;
        if(nums.length == 1){
            if(nums[0] == target){
                res[0] = 0;
                res[1] = 0;
            }
            return res;
        }
        
        int pLeft = 0, pRight = nums.length - 1;
        int mid = pLeft;
        boolean fLeft = true, fRight = false;
        
        if(nums[pLeft] > target || nums[pRight] < target) return res;
        
        while(pLeft < pRight){
            if(nums[mid] == target){
                res[0] = searchFirstOrLast(nums,mid,pLeft,pRight,fLeft, target);
                res[1] = searchFirstOrLast(nums,mid,pLeft,pRight,fRight, target);
                return res;
            }else if(nums[mid] < target){
                pLeft = mid;
                mid = (pLeft + pRight + 1)/2;   //避免无限循环
            }else{
                if(pLeft == pRight - 1 && nums[pLeft] != target) return res;  //避免target不存在时发生无限循环
                pRight = mid;
                mid = (pLeft + pRight)/2;
            }
            
        }
        return res;
    }
    
    public int searchFirstOrLast(int[] nums, int mid, int pLeft, int pRight, boolean flag, int target){
        // flag: true 搜索First， false 搜索Last
        if(flag){
            // 搜索First position
            pRight = mid;
            while(pLeft < pRight){
                if(nums[mid] == target){
                    if(mid == 0 || nums[mid-1] != target ){  //注意当mid == 0 时不要越界
                        return mid;
                    }
                    pRight = mid;
                    mid = (pLeft + pRight)/2;
                }else{
                    pLeft = mid;
                    mid = (pLeft + pRight + 1)/2;
                }
            }
        }else{
            // 搜索Last position
            pLeft = mid;
            while(pLeft < pRight){
                if(nums[mid] == target){
                    if(mid == nums.length - 1 || nums[mid+1] != target ){  //注意当mid == 0 时不要越界
                        return mid;
                    }
                    pLeft = mid;
                    mid = (pLeft + pRight + 1)/2;
                }else{
                    pRight = mid;
                    mid = (pLeft + pRight)/2;
                }
            }
        }
        return mid;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(\log n)$

空间复杂度：$O(1)$


