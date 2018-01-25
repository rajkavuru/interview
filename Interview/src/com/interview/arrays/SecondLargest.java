package com.interview.arrays;

public class SecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[]{10,29,20,5,6,25,27,45};
		
		int max1 = 0, max2 = 0,max3 = 0;
		
		for(int i = 0; i < array.length ; i++){
			if(array[i] > max1){
				max3 = max2;
				max2 = max1;
				max1 = array[i];
			}
//			Below else if block added to get third largest
			else if(array[i] > max2){
				max3 = max2;
				max2 = array[i];
			}
			else if(array[i] > max3)
				max3 = array[i];
		}
		System.out.println("First Largest :"+max1);
		System.out.println("Second Largest:"+max2);
		System.out.println("Third Largest :"+max3);
	}

}
