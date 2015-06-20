package com.decoderz.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeImpl {

	public static void main(String[] args) throws Exception {

		BinaryTreeImpl binryTreeImp = new BinaryTreeImpl();

		char[] inOrder = new char[] { 'D', 'B', 'E', 'A', 'F', 'C', 'G' };

		char[] postOrder = new char[] { 'D', 'E', 'B', 'F', 'G', 'C', 'A' };

		List<Character> inOrderList = new ArrayList<>();

		for (char i : inOrder)
			inOrderList.add(i);

		List<Character> postOrderList = new ArrayList<>();

		for (char i : postOrder)
			postOrderList.add(i);

		Node root = binryTreeImp.constructTree(inOrderList, postOrderList, 0,
				inOrder.length-1, 0, postOrder.length-1);

		binryTreeImp.preOrderWithRecursion(root);

	}

	private Node constructTree(List<Character> inOrderList,
			List<Character> postOrderList, int inStart, int inEnd, int postStart,
			int postEnd) throws Exception {

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

	private void preOrderWithRecursion(Node root) {

		if (root != null) {
			System.out.print(root.getData()+"\t");
			preOrderWithRecursion(root.getLeft());
			preOrderWithRecursion(root.getRight());

		}
	}
}
