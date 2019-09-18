# 5. 最长回文子串
https://leetcode-cn.com/problems/longest-palindromic-substring/

## 题目描述

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

```
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
```

示例 2：
```
输入: "cbbd"
输出: "bb"
```

## 题解

### 解决思路：

遍历字符串的每个字符，查找以当前字符为中心的的最长回文子串。最终输出最长回文子串。

### 代码

java代码:
~~~ java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        // String res = "";
        // 使用start和end指针代替子串，减少消耗
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            // 中心可能是某个字符，也可能是两个字符的中间
            int len1 = expandFunc(s, i, i);
            int len2 = expandFunc(s, i, i+1);
            int len = Math.max(len1, len2);
            // if (len > res.length()){
            if(len > end - start){
                // res = s.substring(i - (len - 1) / 2, i + len/2 + 1);
                start = i - (len - 1) / 2;
                end = i + len/2 + 1;
            }
        }
        // return res;
        return s.substring(start, end);
    
    }
    
    int expandFunc(String s, int L, int R){
        // 左右扩展回文子串
        // 注意边界条件
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n^2)$

空间复杂度：$O(1)$

## 其他方法
