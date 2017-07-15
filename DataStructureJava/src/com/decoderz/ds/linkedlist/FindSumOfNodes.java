package com.decoderz.ds.linkedlist;

import java.util.Scanner;

/**
 * Problem :
 * 
 * 
 * Given two numbers represented by two linked lists, write a function that
 * returns sum list. The sum list is linked list representation of addition of
 * two input numbers. It is not allowed to modify the lists. Also, not allowed
 * to use explicit extra space
 * 
 * Input: First List: 5->6->3 (represents number 563) Second List: 8->4->2
 * (represents number 842) Output: Resultant list: 1->4->0->5 (represents number
 * 1405)
 * 
 * @author karthikeyan.v
 *
 */
public class FindSumOfNodes {

	public static void main(String[] args) {

		FindSumOfNodes instance = new FindSumOfNodes();
		Scanner scanner = new Scanner(System.in);

		String firstNumber = scanner.nextLine();
		String secondNumber = scanner.nextLine();

		Node firstHead = instance.constructLinkedList(firstNumber);
		Node secondHead = instance.constructLinkedList(secondNumber);

		Node currentNode = firstHead;

	}

	Node constructLinkedList(String number) {

		Node head = null;
		Node current = null;
		for (char c : number.toCharArray()) {

			Node node = new Node();
			node.setValue(Integer.parseInt(String.valueOf(c)));
			node.setNext(null);

			if (head == null) {
				head = node;
				current = node;
			} else {
				current.setNext(node);
				current = node;
			}
		}

		return head;

	}

	public class Node {

		private int value;
		private Node next;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

}
