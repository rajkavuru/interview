package com.interview.bst;

/*
 * https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 */

public class SubTree {
	
	static class  BinaryTree{
		BinaryTree left;
		BinaryTree right;
		int data;
		
		BinaryTree(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static boolean isSubTree(BinaryTree tree, BinaryTree subTree){
		
		if(subTree == null) return true;
		
		if(tree == null) return false;
		
		if(areIdentical(tree, subTree))
			return true;
		
		return (isSubTree(tree.left, subTree) ||
				isSubTree(tree.right, subTree));
	}
	
	public static boolean areIdentical(BinaryTree tree, BinaryTree subTree){
		if(tree == null && subTree == null)
			return true;
		
		if(tree == null || subTree == null)
			return false;
		
		return (tree.data == subTree.data ||
				areIdentical(tree.left, subTree) ||
				areIdentical(tree.right, subTree));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree root1, root2;
		
		root1 = new BinaryTree(26);
        root1.right = new BinaryTree(3);
        root1.right.right = new BinaryTree(3);
        root1.left = new BinaryTree(10);
        root1.left.left = new BinaryTree(4);
        root1.left.left.right = new BinaryTree(30);
        root1.left.right = new BinaryTree(6);
  
        root2 = new BinaryTree(10);
        root2.right = new BinaryTree(6);
        root2.left = new BinaryTree(4);
        root2.left.right = new BinaryTree(30);
		
        System.out.println("Is Subtree: "+isSubTree(root1, root2));

	}

}
