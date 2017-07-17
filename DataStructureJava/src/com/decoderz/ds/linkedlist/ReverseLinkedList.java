package com.decoderz.ds.linkedlist;

import java.util.Scanner;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList instance = new ReverseLinkedList();
		Scanner scanner = new Scanner(System.in);
		System.out.println("###### Linked list Reversing ######");
		Node head = instance.constructLinkedList(scanner);
		System.out.println("Before reversing list : ");
		instance.displayAllValues(head);
		head = instance.reverseUsingIteration(head);
		System.out.println("After reversing list (Iteration) : ");
		instance.displayAllValues(head);
		System.out.println("Reversing again ( Recursion ) : ");
		head = instance.reverseUsingRecursion(head, null);
		instance.displayAllValues(head);
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

	private Node getPointertoNode(Node node1) {

		Node tmp = null;
		if (node1 != null) {
			tmp = new Node();
			tmp.setNext(node1.getNext());
			tmp.setValue(node1.getValue());
		}
		return tmp;
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

	private Node reverseUsingIteration(Node head) {
		Node current = head;
		Node prev = null;
		Node next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
	}

	private Node reverseUsingRecursion(Node head,Node prev) {
		if (head == null) {
			return prev;
		}
		Node newHead = reverseUsingRecursion(head.getNext(),head);
		head.setNext(prev);
		return newHead;
	}

}
