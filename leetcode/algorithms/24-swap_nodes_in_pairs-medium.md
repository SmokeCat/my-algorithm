# 1. 两数之和
https://leetcode-cn.com/problems/swap-nodes-in-pairs/

## 题目描述

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:
```
给定 1->2->3->4, 你应该返回 2->1->4->3.
```

## 题解

### 解决思路：

TODO：图解

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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode listHead = new ListNode(0);
        ListNode pre = listHead, self = head, next = self.next;
        
        while(self != null && self.next != null){
        	pre.next = next;
        	self.next = next.next;
        	next.next = self;
        	
        	pre = self;
        	self = pre.next;
        	if(self == null || self.next == null) break;
        	next = self.next;
        }
        
        return listHead.next;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(1)$
