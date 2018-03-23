package com.interview.threads;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CheckSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] events = {"4","ACQUIRE 364","ACQUIRE 84","RELEASE 364","RELEASE 84"};
		System.out.println(checkSequence(events));
	}

	public static int checkSequence(String[] events) {
		if (events == null || events.length < 1) {
			return 0;
		} else {
			int step = 1;
			Stack<String> lock = new Stack<String>();
			Set<String> records = new HashSet<String>();
			for (String l : events) {
				String[] array = l.split(" ");
				if (array[0].equals("ACQUIRE")) {
					if (records.contains(array[1])) {
						return step;
					}
					records.add(array[1]);
					lock.push(array[1]);
				} else {
					if (lock.isEmpty() || !lock.peek().equals(array[1])) {
						return step;
					}
					lock.pop();
					records.remove(array[1]);
				}
				step++;
			}
			if (!lock.isEmpty()) {
				return events.length + 1;
			}
			return 0;
		}
	}
}
