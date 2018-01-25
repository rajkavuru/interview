package com.interview.priority;

import java.util.*;

public class AmazonWareHouse {

	public List<List<Integer>> topK(List<List<Integer>> input, int n, int m) {
		
		PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(n,
				new Comparator<List<Integer>>() {
					public int compare(List<Integer> e1, List<Integer> e2) {
						return e1.get(0) * e1.get(0) + e1.get(1) * e1.get(1)
								- e2.get(0) * e2.get(0) - e2.get(1) * e2.get(1);
					}
				});
		for (List<Integer> e1 : input) {
			pq.add(e1);
		}
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < m && i < n; i++) {
			result.add(pq.remove());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
