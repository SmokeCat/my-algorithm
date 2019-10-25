package com.smoke.util.linkedlist.singly;

public class LinkedList {
	private int size = 0;
	
	/*
	 * head.next 为链表的第一个节点
	 */
	private ListNode head;
	
	public LinkedList(){ head = new ListNode(); }
	
	/**
	 * 用给定的数组list创建一个单链表
	 * 
	 * @param list
	 */
	public LinkedList(int[] list){
		head = new ListNode();
		
		ListNode curNode = head;
		for(int i = 0; i < list.length; i++){
			ListNode node = new ListNode(list[i]);
			curNode.next = node;
			curNode = curNode.next;
		}
		size = list.length;
	}
	
	/**
	 * 创建一个长度为cap， 每个节点的value值为val的单链表。
	 * 
	 * @param cap	链表长度
	 * @param val	用于填充节点的value值
	 */
	public LinkedList(int cap, int val){
		head = new ListNode();
		
		ListNode curNode = head;
		for(int i = 0; i < cap; i++){
			ListNode node = new ListNode(val);
			curNode.next = node;
			curNode = curNode.next;
		}
		size = cap;
	}
	
	public ListNode getHead(){ return head; }
	
	public ListNode get(int index){
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
		ListNode x = head;
		for(int i = 0; i < index; i++){
			x = x.next;
		}
		return x;
	}
	
	public void setFirst(ListNode first){
		head.next = first;
	}
	
	public String toString(){
		ListNode curNode = head.next;
		if(curNode == null) return "[]";
		
		StringBuilder str = new StringBuilder();
		str.append('[');
		while(curNode != null){
			str.append(curNode.val);
			if (curNode.next == null) {
				break;
			}
			str.append(", ");
			curNode = curNode.next;
		}
		return str.append(']').toString();
	}

}
