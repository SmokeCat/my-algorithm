# 3. 无重复字符的最长字串
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

## 题目描述

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例1:
```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

示例2:
```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

示例3:
```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

## 题解

### 解决思路：

暴力法，遍历所有的子字符串，查看是否有重复的字符。

### 代码

java代码:
~~~ java
/*
 * 复杂度太高，效率过于低，不写了。
~~~

### 复杂度分析：

时间复杂度：$O(n^3)$

空间复杂度：$O(n)$

## 其他方法1

### 思路

用滑动窗口的概念，不需要遍历所有的子字符串，也不用遍历寻找重复的字符。

从第一个字符开始，查看后面的一个字符是否与窗口里的重复。

如果不重复，则将窗口的后界+1，即将那个字符加进窗口里。

遇到第一个重复的字符s时，将窗口的前界置为窗口内与s重复的字符的后一个，并将后界+1。此时的窗口是一个无重复字符的子字符串，以此持续下去，直至遍历到最后一个字符。

### 代码

java代码:
~~~ java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();
        // 滑动窗口[i, j]
        for(int i = 0, j = 0; j < len; j++){
            while(map.containsKey(s.charAt(j))){
                // 移动滑动窗口前界到与j重复的字符后
                map.remove(s.charAt(i++));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, map.size());
        }
        return res;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

虽然有嵌套循环，但是最坏的情况下是每个字符遍历两遍，即$O(2n)$。

空间复杂度：$O(n)$

## 其他方法2

### 思路

上个方法在移动窗口前界依然是循环remove，用指针i和j表示窗口范围就可以优化。

### 代码

java代码:
~~~ java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();
        // 滑动窗口[i, j]
        for(int i = 0, j = 0; j < len; j++){
            if(map.containsKey(s.charAt(j))){
                // 移动滑动窗口前界到与j重复的字符后
                // 此时的i应该是s.charAt(j)的的索引+1，所以将后面的put操作和res操作都+1。
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j+1);
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

虽然有嵌套循环，但是最坏的情况下是每个字符遍历两遍，即$O(2n)$。

空间复杂度：$O(n)$