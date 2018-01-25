package com.interview.Bit;

public class GreyCode {

	public static boolean greyCode(int x, int y){
		byte temp = (byte) (x^y);
		int total = 0;
		while(temp != 0){
		    temp = (byte) (temp & (temp - 1));
		    total++;
		}
		if(total == 1) 
			return true; 
		else 
			return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(greyCode(2, 1));
	}

}
