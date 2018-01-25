package com.interview.string;

/*
 * LeetCode 125
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
* 
*/
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pal = "A man, a plan, a canal: Panama";
		
		System.out.println("Palindrome:" +isPalindrome(pal));
	}
	
	public static boolean isPalindrome(String s){
		
		if(s == null || s.length()== 0) return true;
		
		int head = 0;
		int tail = s.length()-1;
		char cHead;
		char cTail;
		
		while(head < tail){
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			
			if(!Character.isLetterOrDigit(cHead))
				head++;
			else if(!Character.isLetterOrDigit(cTail))
				tail--;
			else {
				if(Character.toLowerCase(cHead) == Character.toLowerCase(cTail)){
					head++; tail--;					
				}
				else
					return false;
			}			
		}
		return true;
	}
		
		

}
	
