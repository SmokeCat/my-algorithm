# 6. Z字形变换
https://leetcode-cn.com/problems/zigzag-conversion/

## 题目描述

将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

```
string convert(string s, int numRows);
```

示例 1:
```
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
```

示例 2:
```
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G
```

## 题解

### 解决思路：

若行数为1或者字符串长度小于等于给定行数，则直接输出原字符串。

若行数大于1且原字符串不为空，则分为两种情况：

首先根据行数可以得出第一行字符索引的间隔step = 2 * n - 2

    1. 首行和末行的字符索引就是行号i + step * x, 其中 x = 0, 1, 2 ...。
    2. 中间行除了间隔step的字符外，还要额外添加一个字符，这个额外字符的索引= j + instep，其中instep = step - i * 2。

由以上规则可以解出此题。

### 代码

java代码:
~~~ java
class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        // 特殊情况
        if (numRows == 1 || len <= numRows){
            return s;
        }else if(numRows < 1 || s == null){
            return null;
        }
        char[] res = new char[len];
        // 根据行数会有固定的步长，即第一行索引的间隔数
        int step = 2 * numRows - 2;
        for(int i = 0, ptr = 0; i < numRows; i++){
            // 按行顺序将字符放入res中
            
            int instep = step - i * 2;
            
            for(int j = i; j < len; ){
                if(ptr < len)
                    res[ptr++] = s.charAt(j);
                // 中间行判断和越界检查
                if(instep != 0 && instep != step && ptr < len && j+instep < len){
                    // 中间行需要额外插入中间字符
                    res[ptr++] = s.charAt(j + instep);
                }
                j = j + step;
            }
        }
        
        return new String(res);
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(n)$

## 其他方法
