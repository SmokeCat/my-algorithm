package com.smoke.solution;

import com.smoke.util.linkedlist.singly.LinkedList;
import com.smoke.util.linkedlist.singly.ListNode;

public class Solution24 {
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
