package com.interview.dynamic;

public class LCSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = new int[] { -6, -3 };

		int n = A.length;
		int curr_max = A[0];
		int global_max = A[0];
		for (int i = 1; i < n; ++i) {
			curr_max = Math.max(A[i], curr_max + A[i]);

			if (global_max < curr_max) {
				global_max = curr_max;
			}
		}

		System.out.println("Largest Contigous Sum:" + global_max);

	}

}
