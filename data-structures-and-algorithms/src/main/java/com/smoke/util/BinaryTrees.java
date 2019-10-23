/**
 * 
 */
package com.smoke.util;

import java.util.ArrayList;
import java.util.List;

import com.smoke.util.node.BinaryTreeNode;

/**
 * 对二叉树的操作
 * 
 * @author Smoke
 *
 */
public class BinaryTree {
	
	private BinaryTree() {}

	/**
	 * 递归前序遍历
	 * 
	 * @param <E>
	 * @param root
	 * @return
	 */
	public static <E> List<E> preOrder(BinaryTreeNode<E> root){
		List<E> resList = new ArrayList<E>();
		if(root == null) return resList;
		
		preOrderRecursive(root, resList);
		
		return resList;
	}
	
	/**
	 * 递归中序遍历
	 * 
	 * @param <E>
	 * @param root
	 * @return
	 */
	public static <E> List<E> inOrder(BinaryTreeNode<E> root){
		List<E> resList = new ArrayList<E>();
		if(root == null) return resList;
		
		inOrderRecursive(root, resList);
		
		return resList;
	}
	
	/**
	 * 递归后序遍历
	 * 
	 * @param <E>
	 * @param root
	 * @return
	 */
	public static <E> List<E> postOrder(BinaryTreeNode<E> root){
		List<E> resList = new ArrayList<E>();
		if(root == null) return resList;
		
		postOrderRecursive(root, resList);
		
		return resList;
	}
	
	/**
	 * 递归实现前序遍历的辅助递归方法
	 * 
	 * @param <E>
	 * @param root
	 * @param list
	 */
	private static <E> void preOrderRecursive(BinaryTreeNode<E> root, List<E> list){
		list.add(root.getItem());
		
		if(root.getLeftChild() != null)	preOrderRecursive(root.getLeftChild(), list);
		
		if(root.getRightChild() != null) preOrderRecursive(root.getRightChild(), list);
	}

	/**
	 * 
	 * 
	 * @param <E>
	 * @param root
	 * @param list
	 * @param depth 控制递归层数
	 */
//	private static <E> void preOrderRecursive(BinaryTreeNode<E> root, List<E> list, int depth){}
	
	/**
	 * 递归实现中序遍历的辅助递归方法
	 * 
	 * @param <E>
	 * @param root
	 * @param list
	 */
	private static <E> void inOrderRecursive(BinaryTreeNode<E> root, List<E> list){
		if(root.getLeftChild() != null)	inOrderRecursive(root.getLeftChild(), list);
		
		list.add(root.getItem());
		
		if(root.getRightChild() != null) inOrderRecursive(root.getRightChild(), list);
	}

	/**
	 * 
	 * 
	 * @param <E>
	 * @param root
	 * @param list
	 * @param depth 控制递归层数
	 */
//	private static <E> void inOrderRecursive(BinaryTreeNode<E> root, List<E> list, int depth){}
	
	/**
	 * 递归实现后序遍历的辅助递归方法
	 * 
	 * @param <E>
	 * @param root
	 * @param list
	 */
	private static <E> void postOrderRecursive(BinaryTreeNode<E> root, List<E> list){
		if(root.getLeftChild() != null)	postOrderRecursive(root.getLeftChild(), list);
		
		if(root.getRightChild() != null) postOrderRecursive(root.getRightChild(), list);
		
		list.add(root.getItem());
	}

	/**
	 * 
	 * 
	 * @param <E>
	 * @param root
	 * @param list
	 * @param depth 控制递归层数
	 */
//	private static <E> void postOrderRecusive(BinaryTreeNode<E> root, List<E> list, int depth){}

}
