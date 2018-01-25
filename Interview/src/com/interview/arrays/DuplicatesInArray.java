package com.interview.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 * O(N) - Time Complexity
 * O(1) - Space Complexity
 * 
 */

public class DuplicatesInArray {
	
	public static List<Integer> dupsInArray(int[] arr){
		
		Set<Integer> result = new HashSet<Integer>();
		/*[-2, -1, 2]
		 * i = 0
		 * index = 2 - 1 = 1
		 * result[
		 * 
		 * */
		for(int i = 0; i < arr.length; i++){
			int index = Math.abs(arr[i]) - 1;
			if(arr[index] < 0)
				result.add(Math.abs(arr[i]));
			else
				arr[index] = -arr[index];				
		}
		
		for(int i = 0; i < arr.length; i++)
			arr[i] = Math.abs(arr[i]);
		
		return new ArrayList<Integer>(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {2,1,2,1,3};
		
		List<Integer> list = dupsInArray(array);
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i));

	}
}
