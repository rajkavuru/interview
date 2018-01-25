package com.interview.priority;

import java.util.*;

/*
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/description/
 */
public class CuttingTrees {

	   static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

	    public static int cutOffTree(List<List<Integer>> forest) {
	        if (forest == null || forest.size() == 0) return 0;
	        int m = forest.size(), n = forest.get(0).size();

	        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (forest.get(i).get(j) > 1) {
	                    pq.add(new int[] {i, j, forest.get(i).get(j)});
	                }
	            }
	        }

	        int[] start = new int[2];
	        int sum = 0;
	        while (!pq.isEmpty()) {
	            int[] tree = pq.poll();
	            int step = minStep(forest, start, tree, m, n);

	            if (step < 0) return -1;
	            sum += step;

	            start[0] = tree[0];
	            start[1] = tree[1];
	        }

	        return sum;
	    }

	    public static int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
	        int step = 0;
	        boolean[][] visited = new boolean[m][n];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(start);
	        visited[start[0]][start[1]] = true;

	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                int[] curr = queue.poll();
	                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;

	                for (int[] d : dir) {
	                    int nr = curr[0] + d[0];
	                    int nc = curr[1] + d[1];
	                    if (nr < 0 || nr >= m || nc < 0 || nc >= n 
	                        || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
	                    queue.add(new int[] {nr, nc});
	                    visited[nr][nc] = true;
	                }
	            }
	            step++;
	        }

	        return -1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> inner1 = new ArrayList<Integer>();
		inner1.add(1);
		inner1.add(3);
		inner1.add(0);
		inner1.add(2);
		
		List<Integer> inner2 = new ArrayList<Integer>();
		inner2.add(1);
		inner2.add(1);
		inner2.add(3);
		inner2.add(1);
		
		List<Integer> inner3 = new ArrayList<Integer>();
		inner3.add(7);
		inner3.add(6);
		inner3.add(5);
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(inner1);
		list.add(inner2);
//		list.add(inner3);
		
		System.out.println(+cutOffTree(list));
		
	}

}
