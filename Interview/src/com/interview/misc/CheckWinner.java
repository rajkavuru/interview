package com.interview.misc;

import java.util.*;

public class CheckWinner {

	public int checkWinner(List<List<String>> codeList,
			List<String> shoppingCart) {

		if (codeList == null || codeList.isEmpty())
			return 1;
		if (shoppingCart == null)
			return 0;

		int cartPointer = 0;
		int result = 0;
		// Iterate through the outer code list, chunk by chunk
		for (int i = 0; i < codeList.size(); i++) {
			// Iterate within each sub code list, checking String by String:
			// while one sub list is finished successfully, go locate the next
			// start of sub list within cart;
			// If one sub list failed to match, go to next cart pointer and
			// continue search current sub list.
			for (int innerListItemPointer = 0; innerListItemPointer < codeList
					.get(i).size();) {
				/*
				 * We do not want to increase pointer to all cases here so I
				 * will leave the handling of pointer ++ operation to each case.
				 */
				// If the end of shoppingCart is before we can iterate all code
				// list, return false;
				// System.out.println("Lopping ");
				if (cartPointer == shoppingCart.size()) {
					// System.out.println("cartlimit reached, breaking test. ");
					result = 0;
					break;
				}
				// set the result to true, go to next sub list element (j ++)
				// and next cart element (cartPointer ++);
				if (shoppingCart.get(cartPointer).equals(
						codeList.get(i).get(innerListItemPointer))
						|| codeList.get(i).get(innerListItemPointer)
						.equals("anything")) {
					result = 1;
					innerListItemPointer++;
					cartPointer++;
				}
				// The case when current cart element does not match the later
				// patterns of sub code list,
				// but equals to the start of sub code list. eg: Code list [[A,
				// B]] cart: [A, A, B]
				else if (shoppingCart.get(cartPointer).equals(
						codeList.get(i).get(0))) {
					cartPointer++;
					result = 1;
				} else {
					// When the given String does not meet the sub list's
					// pattern, move to next cart item
					// and reset the current sub list pointer index . 1point
					// 3acres ? ? ? List
					innerListItemPointer = 0;
					result = 0;
					cartPointer++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
