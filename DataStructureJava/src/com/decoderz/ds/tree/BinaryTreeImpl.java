package com.decoderz.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeImpl {

	public static void main(String[] args) throws Exception {
		// Binary Tree Construction with given inOrder and postOrder
		BinaryTreeImpl binryTreeImp = new BinaryTreeImpl();

		char[] inOrder = new char[] { 'D', 'B', 'E', 'A', 'F', 'C', 'G' };

		char[] postOrder = new char[] { 'D', 'E', 'B', 'F', 'G', 'C', 'A' };

		List<Character> inOrderList = new ArrayList<>();

		for (char i : inOrder)
			inOrderList.add(i);

		List<Character> postOrderList = new ArrayList<>();

		for (char i : postOrder)
			postOrderList.add(i);

		// Connstructing 
		Node root = binryTreeImp.constructTree(inOrderList, postOrderList, 0,
				inOrder.length - 1, 0, postOrder.length - 1);

		System.out.println("Pre Order With Recurssion : ");
		binryTreeImp.preOrderWithRecursion(root);

		System.out.println();
		System.out.println("Pre Order With Out Recurssion : ");
		binryTreeImp.preOrderWithOutRecurssion(root);

		System.out.println("In Order With Recurssion : ");
		binryTreeImp.inOrderWithRecursion(root);
		
		System.out.println();
		System.out.println("In Order With Out  Recurssion : ");
		binryTreeImp.inOrderWithOutRecursion(root);

	}

	private Node constructTree(List<Character> inOrderList,
			List<Character> postOrderList, int inStart, int inEnd,
			int postStart, int postEnd) throws Exception {

		if (inStart > inEnd || postStart > postEnd)
			return null;

		char data = postOrderList.get(postEnd);
		int index = inOrderList.indexOf(data);

		Node root = new Node(data);

		root.setLeft(constructTree(inOrderList, postOrderList, inStart,
				index - 1, postStart, postStart + (index - (inStart + 1))));
		root.setRight(constructTree(inOrderList, postOrderList, index + 1,
				inEnd, postStart + index - inStart, postEnd - 1));
		return root;
	}

	/**
	 * Method for PreOrder Traversal for a binary tree with recursive calls.
	 * 
	 * @param root
	 */
	private void preOrderWithRecursion(Node root) {

		if (root != null) {
			System.out.print(root.getData() + " ");
			preOrderWithRecursion(root.getLeft());
			preOrderWithRecursion(root.getRight());

		}

	}

	/**
	 * Method for pre order traversal for without using recursion.
	 * 
	 * @param root
	 */
	private void preOrderWithOutRecurssion(Node root) {
		LinkedList<Node> stack = new LinkedList<Node>();

		stack.push(root);
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.getData() + " ");

			if (temp.getRight() != null)
				stack.push(temp.getRight());

			if (temp.getLeft() != null)
				stack.push(temp.getLeft());

		}
		System.out.println();
	}

	/**
	 * Method for InOrder Traversal for a binary tree with recursive calls.
	 * 
	 * @param root
	 */
	private void inOrderWithRecursion(Node root) {
		if (root != null) {
			inOrderWithRecursion(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrderWithRecursion(root.getRight());

		}
	}

	/**
	 * Method for InOrder Traversal for a binary tree with out recursive calls.
	 * 
	 * @param root
	 */
	private void inOrderWithOutRecursion(Node root) {
		LinkedList<Node> stack = new LinkedList<Node>();

		Node temp = root;
		while (temp != null || !stack.isEmpty()) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.getLeft();
			} else {
				temp = stack.pop();
				System.out.print(temp.getData() + " ");
				temp = temp.getRight();
			}
		}
		System.out.println();
	}
}
