package com.interview.misc;

import java.util.*;


class LinkedListNode {
	String key, data;
	LinkedListNode node;

	public LinkedListNode(String key, String data) {
		this.key = key;
		this.data = data;
	}
	
}

public class LRUCache {
	int capacity;

	// LinkedListNode holds key and value pairs
	HashMap<String, LinkedListNode> cache;
	LinkedList<LinkedListNode> cache_vals;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<String, LinkedListNode>(capacity);
		cache_vals = new LinkedList<LinkedListNode>();
		System.out.println("SIZE OK");
	}
	
	
	public static void lruImplementation(){
		
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		
		LRUCache obj ;
        while(true){
			
			String[] tokens = s.split(" ");
			if(tokens[0].equals("SIZE")){
			
				try{
					int size = Integer.parseInt(tokens[1]);
					obj = new LRUCache(size);
					break;
				}catch(Exception e){
					System.out.println("ERROR");
					continue;
				}
			}
		}
		while(true){
			s = in.nextLine();
			String[] tokens = s.split(" ");
			String value = "";
			if( tokens[0].equals("GET")){
				try {
					if(tokens[1].isEmpty() || tokens.length != 2){
						System.out.println("ERROR");
					}
					else{
						value = obj.get(tokens[1]);
						if(value.equals("NOTFOUND"))
							System.out.println("NOTFOUND");
						else
							System.out.println("GOT "+value);
					}
						
				} catch (Exception e) {
					System.out.println("ERROR");
				}
				
			}
			else if( tokens[0].equals("SET")){
				try {
					if(tokens[1].isEmpty() || tokens.length != 3)
						System.out.println("ERROR");
					else{
						obj.set(tokens[1], tokens[2]);
						System.out.println("SET OK");
					}
						
				} catch (Exception e) {
					System.out.println("ERROR");
				}finally{
					
				}
			}
				
			else if( tokens[0].equals("EXIT")){
				in.close();
				break;
			}
			else	
				System.out.println("ERROR");
		}
	}

	String get(String key) {
		LinkedListNode node = cache.get(key);

		if (node == null) {
			return "NOTFOUND";
		} else {
			cache_vals.remove(node);
			cache_vals.addLast(node);
			return node.data;
		}
	}

	void set(String key, String value) {
		LinkedListNode node = cache.get(key);

		if (node == null) {
			evict_if_needed();
			node = new LinkedListNode(key, value);
			cache_vals.addLast(node);
			cache.put(key, node);
		} else {
			node.data = value;
			cache_vals.remove(node);
			cache_vals.addLast(node);
		}
	}

	void evict_if_needed() {
		if (cache_vals.size() >= capacity) {
			LinkedListNode node = cache_vals.remove();
			cache.remove(node.key);
		}
	}

	public static void main(String[] args){
		
		lruImplementation();
	}
}
