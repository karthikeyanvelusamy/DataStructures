package com.decoderz.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTImpl {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void insert(int newValue) {
		Node currentNode = root;
		Node newNode = new Node(newValue);

		if (root == null) {
			root = newNode;
			return;
		}
		while (true) {
			// Currently this implementation dont support duplicate

			if (currentNode.getData() == newValue) {
				System.out
						.println("Value Already Present!..Duplicates Not Allowed!!!");
				return;
			}
			if (currentNode.getData() < newValue) {
				if (currentNode.getRight() == null) {
					currentNode.setRight(newNode);
					break;
				} else {
					currentNode = currentNode.getRight();
				}

			} else {
				if (currentNode.getLeft() == null) {
					currentNode.setLeft(newNode);
					break;
				} else {
					currentNode = currentNode.getLeft();
				}
			}
		}
	}

	public Node predecessor(int value) {

		Node node = searchNode(value);
		if (node == null) {
			System.out.println("Value not found in tree!!...");
			return null;
		}

		if (node.getLeft() != null) {
			return maxValue(node.getLeft());
		} else {
			Node ptr = root;
			Node predecessorNode = null;
			while (ptr != null) {

				if (ptr.getData() > value) {
					ptr = ptr.getLeft();
				} else if (ptr.getData() < value) {
					predecessorNode = ptr;
					ptr = ptr.getRight();
				} else {
					break;
				}
			}

			return predecessorNode;

		}

	}

	public Node successor(int value) {

		Node node = searchNode(value);

		if (node == null) {
			System.out.println("Value not found in tree!!...");
			return null;
		}

		if (node.getRight() != null) {
			return minValue(node.getRight());
		} else {

			Node ptr = root;
			Node succesorNode = null;
			while (ptr != null) {
				if (ptr.getData() > node.getData()) {
					succesorNode = ptr;
					ptr = ptr.getLeft();
				} else if (ptr.getData() < node.getData()) {
					ptr = ptr.getRight();
				} else {
					break;
				}

			}
			return succesorNode;

		}

	}

	public Node searchNode(int value) {

		if (isEmptyTree()) {
			System.out.println("Emptty Tree...");
			return null;
		}
		Node ptr = root;
		while (ptr != null) {
			if (ptr.getData() > value) {
				ptr = ptr.getLeft();
			} else if (ptr.getData() < value) {
				ptr = ptr.getRight();
			} else {
				break;
			}
		}
		return ptr;
	}

	public Node minValue(Node root) {
		if (isEmptyTree()) {
			System.out.println("Empty Tree...");
		}
		Node ptr = root;
		while (ptr.getLeft() != null) {
			ptr = ptr.getLeft();
		}

		return ptr;
	}

	public Node maxValue(Node root) {
		if (isEmptyTree()) {
			System.out.println("Empty Tree...");
		}
		Node ptr = root;
		while (ptr.getRight() != null) {
			ptr = ptr.getRight();
		}

		return ptr;
	}

	private boolean isEmptyTree() {
		boolean isEmpty = false;
		if (root == null) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public void displayLevelUsingIterative() {
		System.out.println("** Tree Starts here***");
		Queue<Node> queue = new LinkedList<>();
		if (isEmptyTree()) {
			System.out.println("Empty Tree...");
			return;
		}

		queue.add(root);
		int nodeCount = queue.size();
		while (queue.size() > 0) {
			nodeCount = queue.size();
			for (int i = 0; i < nodeCount; i++) {
				Node node = queue.element();
				System.out.print(node.getData() + " ");
				if (node.getLeft() != null) {
					queue.add(queue.element().getLeft());
				}
				if (node.getRight() != null) {
					queue.add(queue.element().getRight());
				}
				queue.remove();
			}
			System.out.println();
		}
		System.out.println("** Tree Ends here***");

	}

	public void displayTreeRecurrsivly() {
		int height = height(root);
		for (int i = 1; i <= height; i++) {
			printValueForGivenLevelRecurssivly(root, i);
		}
	}

	private void printValueForGivenLevelRecurssivly(Node root, int level) {

		if (root == null) {
			return;
		} else if (level == 1) {
			viewData(root);
		} else {
			printValueForGivenLevelRecurssivly(root.getLeft(), level - 1);
			printValueForGivenLevelRecurssivly(root.getRight(), level - 1);
		}
	}

	public void viewData(Node node) {

		System.out.print(node.getData() + " ");
	}

	public int height(Node root) {
		if (root == null) {
			return 0;
		} else {
			return Integer.max(height(root.getLeft()), height(root.getRight())) + 1;
		}
	}

}
