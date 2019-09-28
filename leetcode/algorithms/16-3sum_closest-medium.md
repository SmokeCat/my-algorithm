# 6. 最接近的三数之和
https://leetcode-cn.com/problems/3sum-closest/

## 题目描述

给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

```
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
```

## 题解

### 解决思路：

同15题，判断条件改成比较差值。

### 代码

java代码:
~~~ java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0; //数组长度不足
        
        // 排序数组
        Arrays.sort(nums);
        
        int res = nums[0] + nums[1] + nums[2];
        int absResVal = Math.abs(res - target);
        
        for(int i = 0; i < nums.length - 2; i++){
            int pLeft = i + 1, pRight = nums.length - 1;
            while(pLeft < pRight){
                int sum = nums[i] + nums[pLeft] + nums[pRight];
                int difVal = sum - target;
                int absVal = Math.abs(difVal);
                // 更新res
                if(absResVal > absVal){
                    res = sum;
                    absResVal = absVal;
                }
                
                if(difVal == 0) {
                    return sum;
                }else if(difVal > 0){
                    // sum偏大，右指针左移
                    pRight--;
                }else{
                    // sum偏小，左指针右移
                    pLeft++;
                }
            }
            
            // 排除重复
            while(i + 1 < nums.length - 2 && nums[i+1] == nums[i]){i++;}
        }
        
        return res;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n^2)$

空间复杂度：$O(1)$
