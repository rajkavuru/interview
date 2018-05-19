package com.interview.stacks;

import java.util.Stack;

public class BalancedString {
	
	public static char[][] TOKEN = {{'{','}'}, {'[',']'}, {'(',')'}};

	public static boolean openTerm(char c){
		for (char[] array: TOKEN ){
			if(array[0] == c)
			   return true;
		}
		return false;
	}
	
	public static boolean isMatch(char openTerm, char closedTerm){
		for (char[] array: TOKEN ){
			if(array[0] == openTerm)
			   return array[1] == closedTerm;
		}
		return false;
	}
	
	public static boolean isBalanace(String sequence){
		Stack<Character> st = new Stack<Character>();
		
		for(char c : sequence.toCharArray()){
			
			if(openTerm(c)){
				st.push(c);
			}else{
				if(st.isEmpty() || !isMatch(st.pop(),c))
					return false;
				else
					return true;
			}
		}
		return st.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String seq = "{[([()])}]";
		System.out.println(isBalanace(seq));

	}

}
