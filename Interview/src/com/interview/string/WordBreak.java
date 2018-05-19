package com.interview.string;

import java.util.*;

public class WordBreak {

	public static boolean wordBreak(String s, Set<String> wordDict) {
	    int[] pos = new int[s.length()+1];
	 
	    Arrays.fill(pos, -1);
	 
	    pos[0]=0;
	 
	    for(int i=0; i<s.length(); i++){
	        if(pos[i]!=-1){
	            for(int j=i+1; j<=s.length(); j++){
	                String sub = s.substring(i, j);
	                if(wordDict.contains(sub)){
	                    pos[j]=i;
	                }
	            } 
	        }
	    }
	 
	    return pos[s.length()]!=-1;
	}
	
	public static void main(String[] args) {

		Set<String> dict = new HashSet<String>();
		dict.add("I");
		dict.add("am");
		dict.add("a");
		dict.add("test");
		dict.add("ates");
		dict.add("d");
		System.out.println(wordBreak("Iamatesd",dict));
		
		
	}

}
