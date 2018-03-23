package com.interview.string;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/#_=_
 * 
 * Longest Palindromic Substring using Dynamic Programming
 * Time Complexity O(n^2)
 * Space Complaexity O(n^2) -- 2d matrix of length n
 */

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(longestPalindromicSubstr("abcda"));
	}

	public static String longestPalindromicSubstr(String s){
		
		if(s == null || s.length() < 2)
			return s;
		
		int length = s.length();
		
		boolean[][] isPalindrome = new boolean[length][length];
		
		int left = 0;
		int right = 0;
		
		for(int j = 1; j < length; j++){
			for(int i = 0 ; i < j ; i++){
				boolean isInnerWordPalindrome = isPalindrome[i+1][j-1] || j -i <= 2;
				
				if(s.charAt(i) == s.charAt(j) && isInnerWordPalindrome){
					isPalindrome[i][j] = true;
					
					if(j - i > right - left){
						left = i  ;
						right = j ;
					}
				}
			}
		}
		
		return s.substring(left, right + 1);
		
	}
	
	
}
