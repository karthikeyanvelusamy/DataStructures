package com.decoderz.ds.main;

import java.util.Scanner;

import com.decoderz.ds.tree.BSTImpl;
import com.decoderz.ds.tree.Node;

public class BSTDriver {

	public static void main(String[] args) {

		BSTImpl bstTree = new BSTImpl();
		Scanner scanner = new Scanner(System.in);
		String choice;
		do {
			System.out.println("********* Binary Search Tree (BST) **********");
			System.out.println("1.Insert");
			System.out.println("2.Display");
			System.out.println("3.Successor");
			System.out.println("4.Predecessor");
			System.out.println("5.Exit");
			System.out.println("Enter the Choice : ");

			choice = scanner.next();

			switch (choice) {
			case "1":
				System.out.println("Enter the Value : ");
				bstTree.insert(scanner.nextInt());
				System.out.println("After insertion : ");
				bstTree.displayLevelUsingIterative();
				break;

			case "2":
				bstTree.displayLevelUsingIterative();
				break;
			case "3":
				System.out.println("Enter the value to find its successor : ");
				int value = scanner.nextInt();
				Node successorNode = bstTree.successor(value);
				if (successorNode != null)
					System.out.println("Successor of " + value + " is "
							+ successorNode.getData());
				break;
			case "4":
				System.out
						.println("Enter the value to find its predecessor : ");
				value  = scanner.nextInt();
				Node predecessorNode = bstTree.predecessor(value);
				if (predecessorNode != null) {
					System.out.println("Predecessor of " + value + " is " +predecessorNode.getData());
				}
				break;

			default:
				System.out.println("Wrong choice!!");
				break;
			}

		} while (!choice.equalsIgnoreCase("5"));

	}
}