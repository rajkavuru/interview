package com.interview.string;

public class CountPalindromes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countPalindroms("wowpurerocks"));

	}

	public static int countPalindroms (String S) {
		if (S == null || S.isEmpty ()) {
			return 0;
		} 
		char [] array = S.toCharArray ();
		int globalCount = array.length;

		for (int mid = 1; mid <array.length; mid ++) {
			int count = 0;
			int low = mid - 1;
			int high = mid + 1;

			while (low >= 0 && high <array.length && array [low] == array [high]) {
				count ++;
				low--;
				high++;
			}

			globalCount += count;
			count = 0;
			low = mid - 1;
			high = mid;

			while (low >= 0 && high <array.length && array [low] == array [high]) {
				count ++;
				low--;
				high++;
			}

			globalCount += count;
		}
		return globalCount;
	}

}
