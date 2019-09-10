# 2. 两数相加
https://leetcode-cn.com/problems/add-two-numbers/

## 题目描述

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例:
```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

## 题解

### 解决思路：

逐位相加进位，代码注意处理两个链表长度不同甚至为空链表的情况。

### 代码

java代码:
~~~ java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode tmp = l3;
        int sum = 0;    // 和数
        int flag = 0;   // 进位存储
        while(l1 != null || l2 != null || flag != 0){
            
            // 处理l1,l2为null时的情况
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            
            // 处理结果和进位
            sum = v1 + v2 + flag;
            flag = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
        }
        return l3.next;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(max(m,n))$

空间复杂度：$O(max(m,n))$