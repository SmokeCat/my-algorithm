package com.smoke.util.node;

public class BinaryTreeNode<E> {
	E item;
	BinaryTreeNode<E> leftChild; 
	BinaryTreeNode<E> rightChild; 
	
	public BinaryTreeNode(E e){
		item = e;
		leftChild = null;
		rightChild = null;
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	public BinaryTreeNode<E> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(E leftChild) {
		this.leftChild = new BinaryTreeNode<E>(leftChild);
	}

	public BinaryTreeNode<E> getRightChild() {
		return rightChild;
	}

	public void setRightChild(E rightChild) {
		this.rightChild = new BinaryTreeNode<E>(rightChild);
	}
	

}