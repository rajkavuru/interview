package com.interview.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] array = {2,7,12,15};
		int target = 9;
		int[] result = twoSum(array, target);
		Arrays.stream(result).forEach(System.out::println);
		
	}
	
	//[2, 7, 12 , 15]  target 9
	
	public static int[] twoSum(int[] input, int target){
		int[] result = new int[2];
		
		if(input == null || input.length < 1)
			return result;
		
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < input.length; i++){
			if(map.containsKey(input[i])){
				result[0] = map.get(input[i]);
				result[1] = i;
				return result;
			}else{
				map.put(target - input[i], i);
			}
		}
		return result;
	}
}
