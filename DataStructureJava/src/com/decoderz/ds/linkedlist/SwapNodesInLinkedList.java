package com.decoderz.ds.linkedlist;

import java.util.Scanner;

/**
 * Swapping two values in linked list with out swapping the data.
 * 
 * @author karthikeyan.v
 *
 */

public class SwapNodesInLinkedList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SwapNodesInLinkedList instance = new SwapNodesInLinkedList();

		System.out.println("Linked List Swapping");
		Node head = instance.constructLinkedList(scanner);
		System.out.println("Enter the two values as space seperated : ");

		// Get values from user.
		int value1 = scanner.nextInt();
		int value2 = scanner.nextInt();

		System.out.println("Before swap : ");
		instance.displayAllValues(head);

		instance.swapNodes(head, value1, value2);

		System.out.println("After swap : ");
		instance.displayAllValues(head);
	}

	private Node constructLinkedList(Scanner scanner) {
		System.out.println("Enter Values : ");
		boolean flag = true;
		Node head = null;
		Node current = null;
		while (flag) {
			int value = scanner.nextInt();
			Node node = new Node();
			node.setNext(null);
			node.setValue(value);

			if (head == null) {
				head = node;
				current = node;
			} else {
				current.setNext(node);
				current = node;
			}

			System.out.println("Do u want to continue : Y | N");
			String flagStr = scanner.next();
			flag = ("Y".equalsIgnoreCase(flagStr)) ? true : false;
		}
		return head;
	}

	private void displayAllValues(Node head) {
		Node tmp = getPointertoNode(head);
		while (tmp != null) {
			System.out.print(tmp.getValue() + " -> ");
			tmp = tmp.getNext();
		}
		System.out.print("\\");
		System.out.println("");
	}

	public void swapNodes(Node head, int value1, int value2) {
		Node currVal1 = head;
		Node currVal2 = head;
		Node prevVal1 = null;
		Node prevVal2 = null;

		// Getting the position(previous node and the value node) of value 1 in
		// linked list.
		while (currVal1 != null && currVal1.getValue() != value1) {
			prevVal1 = currVal1;
			currVal1 = currVal1.getNext();
		}
		// Getting the position(previous node and the value node) of value 2 in
		// linked list.
		while (currVal2 != null && currVal2.getValue() != value2) {
			prevVal2 = currVal2;
			currVal2 = currVal2.getNext();
		}

		// Checking the value1 is head or not
		if (prevVal1 != null) {
			prevVal1.setNext(currVal2);
		} else {
			head = currVal2;
		}

		// Checking the value1 is head or not
		if (prevVal2 != null) {
			prevVal2.setNext(currVal1);
		} else {
			head = currVal1;
		}
 
		//Swapping the next pointers.
		Node tmp = currVal1.getNext();
		currVal1.setNext(currVal2.getNext());
		currVal2.setNext(tmp);

	}

	private Node getPointertoNode(Node node1) {

		Node tmp = null;
		if (node1 != null) {
			tmp = new Node();
			tmp.setNext(node1.getNext());
			tmp.setValue(node1.getValue());
		}
		return tmp;
	}
}
