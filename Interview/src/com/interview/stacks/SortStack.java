package com.interview.stacks;

import java.util.Stack;

public class SortStack {
	
	public static void sort(Stack<Integer> st){
		Stack<Integer> temp = new Stack<Integer>();
		
		while(!st.isEmpty()){
			int i = st.pop();
			while(!temp.isEmpty() && temp.peek() > i){
				st.push(temp.pop());
			}
			temp.push(i);
		}
		if(st.isEmpty()){
			while(!temp.isEmpty()){
				st.push(temp.pop());
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> sort = new Stack<Integer>();
		sort.push(5);
		sort.push(10);
		sort.push(8);
		sort.push(4);
		sort.push(7);
		sort.push(1);
		System.out.println();
		sort(sort);
		
		while(!sort.isEmpty()){
			System.out.print(sort.pop() + ",");
		}
	}
}
