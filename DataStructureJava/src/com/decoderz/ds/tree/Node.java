package com.decoderz.ds.tree;

public class Node {

	private char data;
	private Node left;
	private Node right;

	Node(char data) {
		this.data = data;
	}

	Node(char data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	
	@Override
	public String toString(){
		return String.valueOf(data);
	}
	
}
