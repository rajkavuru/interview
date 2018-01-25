package com.interview.string;

import java.util.*;
/*
 * Michelle has created a word game for her students. The word game begins with Michelle writing a string and a number, num, on the board.
The students must find a substring of size num such that there is exactly one character that is repeated one;
in other words, there should be num - 1 distinct characters in the substring.

Write an algorithm to help the students find the correct answer. If no such substring can be found, return an empty list;
if multiple such substrings exist, return all them, without repetitions. The order in which the substrings are does not matter.

inputString:
The inputString to the function/method consists of two arguments - inputString, representing the string written by the teacher;
num an integer representing the number, num, written by the teacher on the board.

Output:
Return a list of all substrings of inputString with num characters, that have num-1 distinct character i.e.
exactly one character is repeated, or an empty list if no such substring exist in inputString.
The order in which the substrings are returned does not matter.

Constraints:
The inputString integer can only be greater than or equal to 0 and less than or equal to 26 (0 <= num <= 26)
The inputString string consists of only lowercase alphabetic characters.

Example
inputString:
inputString = awaglk
num = 4

Output:
[awag]

Explanation:
The substrings are {awag, wagl, aglk}
The answer is awag as it has 3 distinct characters in a string of size 4, and only one character is repeated twice.
 */
public class DifferentWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		differntWords ("democracy", 5);
		                
	}
	
	public static List<String> differntWords(String inputString, int num){
		
		if (num> inputString.length ()) return null;
        List <String> result = new ArrayList <String> ();
		
        for(int i = 0; i < inputString.length() - num; i++){
        	String temp = inputString.substring(i, i+num);
        	Set<String> set = new HashSet<String>();
        	
        	for(Character c: temp.toCharArray()){
        		set.add(Character.toString(c));
        	}
        	
        	if(set.size() == num-1 && !result.contains(temp))
        		result.add(temp);
        }
        for(String s: result)
        	System.out.println(s);
        return result;
	}

}
