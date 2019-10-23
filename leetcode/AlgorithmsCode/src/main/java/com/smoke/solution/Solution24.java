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
    
    /**
     * 测试Solution24
     * 
     * @param args
     */
    public static void main(String[] args) {
		System.out.println("Test Solution 24:");
		
		Solution24 s24 = new Solution24();
		
		int[] a = new int[]{1,2,3,4};
		LinkedList list = new LinkedList(a);
		
		ListNode head = list.getHead();
		
		System.out.println("Before handle: ");
		System.out.println(list.toString());
		
		list.setFirst(s24.swapPairs(head.next));;
		
		System.out.println("After handle: ");
		System.out.println(list.toString());
	}
}
