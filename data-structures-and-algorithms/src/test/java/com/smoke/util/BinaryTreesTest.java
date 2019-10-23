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
class BinaryTreesTest {
	
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
	 * Test method for {@link com.smoke.util.BinaryTrees#preOrder(com.smoke.util.node.BinaryTreeNode)}.
	 */
	@Test
	void testPreOrder() {
//		List<Integer> other = new ArrayList<Integer>();
//		other.add(3);
//		other.add(2);
//		other.add(1);
		assertTrue(BinaryTrees.preOrder(emptyTree).equals(new ArrayList<>()), "pre-order emptyTree failed");
		assertTrue(BinaryTrees.preOrder(null).equals(new ArrayList<>()), "pre-order null failed");
		assertTrue(BinaryTrees.preOrder(fullTree).equals(new ArrayList<>(Arrays.asList(1,2,4,5,3,6,7))), "pre-order fullTree failed");
		assertTrue(BinaryTrees.preOrder(leftTree).equals(new ArrayList<>(Arrays.asList(1,2,3))), "pre-order leftTree failed");
		assertTrue(BinaryTrees.preOrder(rightTree).equals(new ArrayList<>(Arrays.asList(1,2,3))), "pre-order rightTree failed");
		assertTrue(BinaryTrees.preOrder(rootTree).equals(new ArrayList<>(Arrays.asList(1))), "pre-order rootTree failed");
	}

	/**
	 * Test method for {@link com.smoke.util.BinaryTrees#inOrder(com.smoke.util.node.BinaryTreeNode)}.
	 */
	@Test
	void testInOrder() {
		assertTrue(BinaryTrees.inOrder(emptyTree).equals(new ArrayList<>()), "pre-order emptyTree failed");
		assertTrue(BinaryTrees.inOrder(null).equals(new ArrayList<>()), "pre-order null failed");
		assertTrue(BinaryTrees.inOrder(fullTree).equals(new ArrayList<>(Arrays.asList(4,2,5,1,6,3,7))), "in-order fullTree failed");
		assertTrue(BinaryTrees.inOrder(leftTree).equals(new ArrayList<>(Arrays.asList(3,2,1))), "in-order leftTree failed");
		assertTrue(BinaryTrees.inOrder(rightTree).equals(new ArrayList<>(Arrays.asList(1,2,3))), "in-order rightTree failed");
		assertTrue(BinaryTrees.inOrder(rootTree).equals(new ArrayList<>(Arrays.asList(1))), "in-order rootTree failed");
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.smoke.util.BinaryTrees#postOrder(com.smoke.util.node.BinaryTreeNode)}.
	 */
	@Test
	void testPostOrder() {
		System.out.println(BinaryTrees.postOrder(fullTree));
		assertTrue(BinaryTrees.postOrder(emptyTree).equals(new ArrayList<>()), "pre-order emptyTree failed");
		assertTrue(BinaryTrees.postOrder(null).equals(new ArrayList<>()), "pre-order null failed");
		assertTrue(BinaryTrees.postOrder(fullTree).equals(new ArrayList<>(Arrays.asList(4,5,2,6,7,3,1))), "post-order fullTree failed");
		assertTrue(BinaryTrees.postOrder(leftTree).equals(new ArrayList<>(Arrays.asList(3,2,1))), "post-order leftTree failed");
		assertTrue(BinaryTrees.postOrder(rightTree).equals(new ArrayList<>(Arrays.asList(3,2,1))), "post-order rightTree failed");
		assertTrue(BinaryTrees.postOrder(rootTree).equals(new ArrayList<>(Arrays.asList(1))), "post-order rootTree failed");
//		fail("Not yet implemented");
	}

}
