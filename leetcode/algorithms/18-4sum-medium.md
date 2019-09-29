# 1. 两数之和
https://leetcode-cn.com/problems/4sum/

## 题目描述

给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：
```
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```

## 题解

### 解决思路：

同#15三数之和解法。

先排序数组，双层嵌套固定两个指针，在剩下的数组里用双指针。

### 代码

java代码:
~~~ java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        
        Arrays.sort(nums);
        
        //四个指针i, j, pLeft, pRight
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                int pLeft = j + 1, pRight = nums.length - 1;
                while(pLeft < pRight){
                    int sum = nums[i] + nums[j] + nums[pLeft] + nums[pRight];
                    if(sum == target){
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[pLeft], nums[pRight])));
                    }
                    
                    // 去重
                    if(sum <= target){
                        while(pLeft + 1 < pRight && nums[pLeft+1] == nums[pLeft]){pLeft++;}
                        pLeft++;
                    }else{
                        while(pLeft + 1 < pRight && nums[pRight-1] == nums[pRight]){pRight--;}
                        pRight--;
                    }
                }
                
                // 第二个指针j去重
                while(j < nums.length - 2 && nums[j+1] == nums[j]){j++;}
            }
            // 第一个指针i去重
            while(i < nums.length - 3 && nums[i+1] == nums[i]){i++;}
        }
        return res;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n^3)$

空间复杂度：$O(1)$

## 其他方法
