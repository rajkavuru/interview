package com.interview.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = {1,2,3,4,5,6};
		int order = 2;
		
		rotateArray(input, order);
		System.out.println(Arrays.toString(input));
	}

	public static void rotateArray(int[] input, int order){
		
		if(input == null || input.length == 0 || order < 0)
			throw new IllegalArgumentException("Illegal Arguments");
		
		if(order > input.length)
			order = order%input.length;
		
		int divide = input.length  - order;
		
		//reverse first part ->[4,3,2,1,5,6]
		reverse(input, 0, divide -1);
		
		//reverse second part ->[4,3,2,1,6,5]
		reverse(input, divide, input.length-1);
		
		//reverse the complete array ->[5,6,1,2,3,4]
		reverse(input,0,input.length-1);
		
	}
	
	public static void reverse(int[] arr, int left, int right){
		
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
