# 66. 加一
https://leetcode-cn.com/problems/plus-one/

## 题目描述

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
```
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
```

示例 2:
```
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
```

## 题解

### 解决思路：

从末尾加1， 模拟加法进位。 



### 代码

java代码:
~~~ java
class Solution {
    public int[] plusOne(int[] digits) {
        // 修改carry 值可以实现加1 - 9的功能
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i] += carry;
            carry = 0;
            if(digits[i] < 10){
                return digits;
            }else{
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }
        }

        // 当加 1-9时，通用
        // if(carry>0 && carry < 10){
        //     int[] newDigits = new int[digits.length + 1];
        //     newDigits[0] = carry;
        //     for(int i = 0; i<digits.length; i++){
        //         newDigits[i + 1] = digits[i];
        //     }
        //     return newDigits;
        // }

        // 全9的数字 加1时，最高位为1，剩余全0
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(1)$
