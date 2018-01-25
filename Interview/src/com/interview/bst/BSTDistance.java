package com.interview.bst;

public class BSTDistance {

    // Global static variable
    static int d1 = -1;
    static int d2 = -1;
    static int dist = 0;
    
    // A Binary Tree Node
    static class Node{
        Node left, right;
        int key;
        
        // constructor
        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }
    
    // Returns level of key k if it is present in tree,
     // otherwise returns -1
    static int findLevel(Node root, int k, int level)
    {
        // Base Case
        if (root == null)
            return -1;
        
        // If key is present at root, or in left subtree or right subtree,
        // return true;
        if (root.key == k)
            return level;
            
        int l = findLevel(root.left, k, level + 1);
        return (l != -1)? l : findLevel(root.right, k, level + 1);
    }
    
    // This function returns pointer to LCA of two given values n1 and n2. 
    // It also sets d1, d2 and dist if one key is not ancestor of other
    // d1 --> To store distance of n1 from root
    // d2 --> To store distance of n2 from root
    // lvl --> Level (or distance from root) of current node
    // dist --> To store distance between n1 and n2
    static Node findDistUtil(Node root, int n1, int n2, int lvl){
        
        // Base case
        if (root == null)
            return null;
        
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root.key == n1){
            d1 = lvl;
            return root;
        }
        if (root.key == n2)
        {
            d2 = lvl;
            return root;
        }
        
        // Look for n1 and n2 in left and right subtrees
        Node left_lca = findDistUtil(root.left, n1, n2,  lvl + 1);
        Node right_lca = findDistUtil(root.right, n1, n2,  lvl + 1);
        
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
        {
            dist = (d1 + d2) - 2*lvl;
            return root;
        }
        
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null)? left_lca : right_lca;    
    }
    
    // The main function that returns distance between n1 and n2
    // This function returns -1 if either n1 or n2 is not present in
    // Binary Tree.
    static int findDistance(Node root, int n1, int n2){
         d1 = -1;
         d2 = -1;
         dist = 0;
        Node lca = findDistUtil(root, n1, n2, 1);
        
        // If both n1 and n2 were present in Binary Tree, return dist
        if (d1 != -1 && d2 != -1)
            return dist;
        
        // If n1 is ancestor of n2, consider n1 as root and find level 
        // of n2 in subtree rooted with n1
        if (d1 != -1)
        {
            dist = findLevel(lca, n2, 0);
            return dist;
        }
        
        // If n2 is ancestor of n1, consider n2 as root and find level 
        // of n1 in subtree rooted with n2
        if (d2 != -1)
        {
            dist = findLevel(lca, n1, 0);
            return dist;
        }
        
        return -1;
    }
    
    public static void createbst(Node root, int value) {
    	if (value < root.key) {
    		if (root.left == null) {
    			root.left = new Node(value);
    		} else {
    			createbst(root.left, value);
    		}
    	} else {
    		if (root.right == null) {
    			root.right = new Node(value);
    		} else {
    			createbst(root.right, value);
    		}
    	}
    }
    
    public static int height(Node root){
    	if(root == null) return 0;
    	
    	int left = height(root.left);
    	int right = height(root.right);
    	return Math.max(left, right) + 1;
    }
    
    public static int size(Node root){
    	if(root == null) return 0;
    	
    	int left = size(root.left);
    	int right = size(root.right);
    	return left + right + 1;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        
        // Let us create binary tree given in the above example
    	
    	int[] array = new int[]{5,6,3,1,2,4};
    	
        Node  root = new Node(array[0]);

        for (int i = 1; i <array.length; i ++) {
    		createbst (root, array[i] );
    	}
        
        System.out.println("height:"+height(root));
        System.out.println("size:"+size(root));
        System.out.println("Dist(14, 20) = "+findDistance(root, 2, 4));
//        System.out.println("Dist(10, 5) = "+findDistance(root, 10, 5));
//        System.out.println("Dist(7, 1) = "+findDistance(root, 7, 1));
    }
}
