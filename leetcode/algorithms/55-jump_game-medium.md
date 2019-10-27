# 55. 跳跃游戏
https://leetcode-cn.com/problems/jump-game/

## 题目描述

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:
```
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
```

示例 2:
```
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
```

## 题解

### 解决思路：

不断更新能跳跃到的最大位置，当最大位置大于等于最后一个元素索引的时候返回true，当遍历的元素在最大位置之后时，则说明无法到达最后的位置。

### 代码

java代码:
~~~ java
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0) return false;
        int maxIndex = 0;
        for(int i = 0; i <= maxIndex; i++){
            maxIndex = (i + nums[i] > maxIndex) ? i + nums[i] : maxIndex;
            if(maxIndex >= len - 1) return true;
        }
        return false;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(1)$