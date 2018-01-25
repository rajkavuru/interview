package com.interview.stacks;


class Node{
	public int data;
	public Node nextNode;
	
	public Node(int x) {
		data = x;
		nextNode = null;
	}
}

class LinkedList{
	Node top;
	
	public LinkedList(){
		top = null;
	}
	
	public void push(int x){
		Node temp = new Node(x);
		temp.nextNode = top;
		top = temp;
	}
	
	public void pop(){
		if (top == null) return ;
		top = top.nextNode;
	}
	
	public void print(){
		if (top == null) return;
		Node temp = null;
		temp = top;
		
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.nextNode;
		}
	}

}
public class StackLinkedLists {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList st = new LinkedList();
		st.push(5);
		st.push(7);
		st.push(12);
		st.pop();
		st.push(15);
		st.print();
	}
}
