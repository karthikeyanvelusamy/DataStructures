package com.decoderz.ds.linkedlist;

import java.util.Scanner;

/**
 * 
 * Finding and removing the loop in a singly linked list.Using floyd's cycle
 * finding algorithm.
 * 
 * 
 * 
 * @author karthikeyan.v
 *
 */

public class FindAndRemoveTheLoop {

	public static void main(String[] args) {
		FindAndRemoveTheLoop instance = new FindAndRemoveTheLoop();
		Scanner scanner = new Scanner(System.in);
		Node head = instance.constructLinkedListWithLoop(scanner);

		// Printing linked list with loop casue the loop running forever.
		// instance.displayAllValues(head);
		instance.findAndRemoveLoop(head);

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

	private Node constructLinkedListWithLoop(Scanner scanner) {

		System.out.println("Linked list creation....");
		System.out.println("Enter the position of loops starts..");
		int pos = scanner.nextInt();
		System.out.println("Enter Values : ");
		boolean flag = true;
		Node head = null;
		Node current = null;
		int count = 1;
		Node loopStartNode = null;
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

			if (count == pos) {
				loopStartNode = node;
			}
			count++;
		}
		current.setNext(loopStartNode);
		return head;
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

	private Node findAndRemoveLoop(Node head) {

		Node slowPointer = head;
		Node fastPointer = head;
		while (slowPointer != null && fastPointer != null
				&& fastPointer.getNext() != null) {

			// The slowpointer moves one node per one iteration where as the
			// fastPointer moves 2 nodes per iteration.
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			if (slowPointer == fastPointer) {
				System.out.println("Found Loop!");
				removeTheLoop(slowPointer, head);
				System.out.println("Loop Removed.\nAfter Removing Loop : ");
				displayAllValues(head);
				break;
			}

		}
		return head;
	}

	private void removeTheLoop(Node loopNode, Node head) {

		Node nonLoopNode = head;

		Node loopNodePointer = loopNode;

		// We have to find out the beaconing of the loop by iterating ptr1 from
		// head and ptr2 with in loop.

		while (true) {
			// Each time we are starting with same loop node.
			loopNodePointer = loopNode;
			// Checks the current nonLoopNode is beginning of loop or we end up
			// in loop.
			while (loopNodePointer.getNext() != loopNode
					&& loopNodePointer.getNext() != nonLoopNode) {
				loopNodePointer = loopNodePointer.getNext();
			}
			// if the above while loop condition breaks due to the current
			// nonloop node is same as the next node of loop node.
			if (loopNodePointer.getNext() == nonLoopNode) {
				break;
			}
			// Current non-loop node is not beginning of loop,so,Moving to next
			// node.
			nonLoopNode = nonLoopNode.getNext();
		}
		// The loopNode pointer will be at the end of the loop so setting the
		// last node next pointer as NULL.
		loopNodePointer.setNext(null);

	}
}
