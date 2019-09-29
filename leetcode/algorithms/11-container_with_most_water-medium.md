# 11. 盛水最多的容器
https://leetcode-cn.com/problems/container-with-most-water/

## 题目描述

给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。


图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

 

示例:
```
输入: [1,8,6,2,5,4,8,3,7]
输出: 49
```

## 题解

### 解决思路：

使用双指针，将两个指针放在两端，此时x轴间隔最长，又因为面积是x轴间距*两边中的最短边，因此为了获得更大的面积，需要移动短的一边。

直到左右指针相遇，循环结束。

### 代码

java代码:
~~~ java
class Solution {
    public int maxArea(int[] height) {
        // 双指针
        int l = 0, r = height.length - 1;
        int max = 0;
        int currMax = 0;
        while(r > l){
            // 每次移动较短的一边，移动长边面积只会减小
            if(height[l] < height[r]){
                currMax = (r - l) * height[l];
                l++;
            }else{
                currMax = (r - l) * height[r];
                r--;
            }
            if(max < currMax) max = currMax;
        }
        return max;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(1)$

## 其他方法

### 解决思路：

嵌套遍历，计算所有两边组合的面积，找出最大面积。
