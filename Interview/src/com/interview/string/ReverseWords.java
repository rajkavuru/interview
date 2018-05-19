package com.interview.string;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "the sky is blue";
		char[] input = str.toCharArray();
		System.out.println(reverseWords(input));
	}
	
	public static char[] reverseWords(char[] s) {
	    int i=0;
	    for(int j=0; j<s.length; j++){
	        if(s[j]==' '){
	            reverse(s, i, j-1);        
	            i=j+1;
	        }
	    }
	    
	    System.out.println(s);
	    reverse(s, i, s.length-1);
	 
	    System.out.println(s);
	    reverse(s, 0, s.length-1);
	    return s;
	}
	 
	public static void reverse(char[] s, int i, int j){
	    while(i<j){
	        char temp = s[i];
	        s[i]=s[j];
	        s[j]=temp;
	        i++;
	        j--;
	    }
	}

}
