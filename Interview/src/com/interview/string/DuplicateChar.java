package com.interview.string;


public class DuplicateChar {

    static String super_reduced_string(String s){
        // Complete this function
        
    	for(int i = 1; i < s.length(); i++){
    		if(s.charAt(i) == s.charAt(i-1)){
    			s = s.substring(0, i-1) + s.substring(i+1);
    			i = 0;
    		}
    	}
    	if(s.length()!= 0) 
    		return s;
    	else 
    		return "Empty String";
        
    }

    public static void main(String[] args) {
    	String input = "baab";
    	String s = "hackerrank";
        String res = "hackerrank";
        
        if(s== null || s.length() < res.length()){
            System.out.println("NO");
            return;
        } 
        int i = 0;
        int count = 0;
        for(char c: s.toCharArray()){
            if(res.charAt(i) == c){
                count++;
                i++;
            }                
        }
        if(count == res.length())
            System.out.println("YES");
        else
            System.out.println("NO");
        
//    	int count = 1;
    	for(char c : input.toCharArray()){
    		if(Character.isUpperCase(c)) count++;
    	}
        String result = super_reduced_string(input);
        System.out.println(result);
    }

}
