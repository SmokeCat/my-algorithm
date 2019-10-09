/**
 * 
 */
package com.smoke.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.smoke.util.node.BinaryTreeNode;

/**
 * @author Smoke
 *
 */
class BinaryTreeTest {
	
	private static BinaryTreeNode<Integer> emptyTree;
	
	private static BinaryTreeNode<Integer> fullTree;
	
	private static BinaryTreeNode<Integer> leftTree;
	
	private static BinaryTreeNode<Integer> rightTree;
	
	private static BinaryTreeNode<Integer> rootTree;
	
	
	/**
	 * 生成测试用数据
	 * emptyTree: null
	 * fullTree: 完全二叉树
	 * leftTree: 只有左子树的树
	 * rightTree: 只有右子树的树
	 * rootTree: 只有一个根节点的树
	 * 
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		/*
		 * 	null
		 */
		emptyTree = null;
		
		/*
		 * 			1
		 * 		   / \
		 * 		  2   3
		 * 		 / \ / \
		 * 		4  5 6	7
		 */
		fullTree = new BinaryTreeNode<Integer>(1);
		fullTree.setLeftChild(2);
		fullTree.setRightChild(3);
		fullTree.getLeftChild().setLeftChild(4);
		fullTree.getLeftChild().setRightChild(5);
		fullTree.getRightChild().setLeftChild(6);
		fullTree.getRightChild().setRightChild(7);
		
		/*
		 * 			1
		 * 		   /
		 * 		  2 
		 * 		 / 
		 * 		3
		 */
		leftTree = new BinaryTreeNode<Integer>(1);
		leftTree.setLeftChild(2);
		leftTree.getLeftChild().setLeftChild(3);
		
		/*
		 * 			1
		 * 		     \
		 * 		      2
		 * 		       \
		 * 		      	3
		 */
		rightTree = new BinaryTreeNode<Integer>(1);
		rightTree.setRightChild(2);
		rightTree.getRightChild().setRightChild(3);
		
		/*
		 * 			1

		 */
		rootTree = new BinaryTreeNode<Integer>(1);
		
	}
	
	/**
	 * Test method for {@link com.smoke.util.BinaryTree#preOrder(com.smoke.util.node.BinaryTreeNode)}.
	 */
	@Test
	void testPreOrder() {
//		List<Integer> other = new ArrayList<Integer>();
//		other.add(3);
//		other.add(2);
//		other.add(1);
		assertTrue(BinaryTree.preOrder(emptyTree).equals(new ArrayList<>()), "pre-order emptyTree failed");
		assertTrue(BinaryTree.preOrder(null).equals(new ArrayList<>()), "pre-order null failed");
		assertTrue(BinaryTree.preOrder(fullTree).equals(new ArrayList<>(Arrays.asList(1,2,4,5,3,6,7))), "pre-order fullTree failed");
		assertTrue(BinaryTree.preOrder(leftTree).equals(new ArrayList<>(Arrays.asList(1,2,3))), "pre-order leftTree failed");
		assertTrue(BinaryTree.preOrder(rightTree).equals(new ArrayList<>(Arrays.asList(1,2,3))), "pre-order rightTree failed");
		assertTrue(BinaryTree.preOrder(rootTree).equals(new ArrayList<>(Arrays.asList(1))), "pre-order rootTree failed");
	}

	/**
	 * Test method for {@link com.smoke.util.BinaryTree#inOrder(com.smoke.util.node.BinaryTreeNode)}.
	 */
	@Test
	void testInOrder() {
		assertTrue(BinaryTree.inOrder(emptyTree).equals(new ArrayList<>()), "pre-order emptyTree failed");
		assertTrue(BinaryTree.inOrder(null).equals(new ArrayList<>()), "pre-order null failed");
		assertTrue(BinaryTree.inOrder(fullTree).equals(new ArrayList<>(Arrays.asList(4,2,5,1,6,3,7))), "in-order fullTree failed");
		assertTrue(BinaryTree.inOrder(leftTree).equals(new ArrayList<>(Arrays.asList(3,2,1))), "in-order leftTree failed");
		assertTrue(BinaryTree.inOrder(rightTree).equals(new ArrayList<>(Arrays.asList(1,2,3))), "in-order rightTree failed");
		assertTrue(BinaryTree.inOrder(rootTree).equals(new ArrayList<>(Arrays.asList(1))), "in-order rootTree failed");
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.smoke.util.BinaryTree#postOrder(com.smoke.util.node.BinaryTreeNode)}.
	 */
	@Test
	void testPostOrder() {
		System.out.println(BinaryTree.postOrder(fullTree));
		assertTrue(BinaryTree.postOrder(emptyTree).equals(new ArrayList<>()), "pre-order emptyTree failed");
		assertTrue(BinaryTree.postOrder(null).equals(new ArrayList<>()), "pre-order null failed");
		assertTrue(BinaryTree.postOrder(fullTree).equals(new ArrayList<>(Arrays.asList(4,5,2,6,7,3,1))), "post-order fullTree failed");
		assertTrue(BinaryTree.postOrder(leftTree).equals(new ArrayList<>(Arrays.asList(3,2,1))), "post-order leftTree failed");
		assertTrue(BinaryTree.postOrder(rightTree).equals(new ArrayList<>(Arrays.asList(3,2,1))), "post-order rightTree failed");
		assertTrue(BinaryTree.postOrder(rootTree).equals(new ArrayList<>(Arrays.asList(1))), "post-order rootTree failed");
//		fail("Not yet implemented");
	}

}
