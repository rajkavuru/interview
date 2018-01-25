package com.interview.string;

import java.util.*;

/*
 *  You are working on developing a movie with Amazon Video and want to devise an application to easily break up individual shots in a video into scenes.
There is already an algorithm that breaks the video up into shots (short sequences from a particular camera angle) and labels them.

Write a function which will partition a sequence of labels into minimal subsequences so that no labels appear in more than one subsequence.
The output should be the length of each subsequence.

Input:
The input to the function/method consists of an argument - inputList, a list of characters representing the sequence of shots.

Output:
Return a list of integers representing the length of each scene, in the order in which it appears in the given sequence of shots.

Example:

Input:
inputList = [a,b,a,b,c,b,a,c,a,d,e,f,e,g,d,e,h,i,j,h,k,l,i,j]
Output:
[9, 7, 8]
Explanation:
The correct partitioning is:
a,b,a,b,c,b,a,c,a,/d,e,f,e,g,d,e,/h,i,j,h,k,l,i,j
To ensure that no label appears in more than one subsequence, subsequences are as small as possible, and subsequences partition the sequence.
The length of these subsequences are 9, 7 and 8.
 */
public class CharacterPartition {
        public static void main (String [] args) {
                List<Character> l = new ArrayList <Character> ();
                l.add ('a') ; //. ? ? ? ? ? ?, ? ? ? ? ?
                l.add ('b');
//                l.add ('a'); //-google 1point3acres
                l.add ('c');
                l.add ('f'); //. From 1point 3acres bbs
                l.add ('a');
                l.add ('b') ; //. Waral ? ? ? ? Wa Wa Wa Wa,
                l.add ('d');
                l.add ('e');
//                l.add ('h');
//                l.add ('i');
//                l.add ('j');
//                l.add ('k');
//                l.add ('i');        
//                l.add ('k');
//                abcfabde
                
//                l.add ('a');
//                l.add ('b');
//                l.add ('a');
//                l.add ('b');
//                l.add ('c');
//                l.add ('b');
//                l.add ('a');
//                l.add ('c');
//                l.add ('a'); 
//                l.add ('d'); 
//                l.add ('e');
//                l.add ('f');
//                l.add ('e');
//                l.add ('g');
//                l.add ('d');
//                l.add ('e');
//                l.add ('h');
//                l.add ('i');
//                l.add ('j');
//                l.add ('h');
//                l.add ('k');        
//                l.add ('l');
//                l.add ('i');
//                l.add ('j');
//
//                l.add ('a');
//                l.add ('b');
//                l.add ('e');
//                l.add ('c');
//                l.add ('a');
//                l.add ('e');
//                l.add ('h');

                charPartition (l);
        }
        
        public static List <Integer> charPartition (List <Character> list) {
                List <Integer> result = new ArrayList <Integer> ();
                for (int i = 0; i <list.size (); i ++) {
                        List <Character> list1 = list.subList (0, i);  
                        List <Character> list2 = list.subList (i, list.size ());
                        
                        for (int j = 0; j <list1.size (); j ++) {
                                if (list2.contains (list1.get (j))) {
                                        break;
                                } else if (! list2.contains (list1.get (j)) && j == list1.size () - 1) {
                                
                                        result.add (i);
                                }
                        }
                        
                }
                
                List <Integer> partList = new ArrayList <Integer> ();
                partList.add (result.get (0));
                if (result.size ()> 1) {
                        for (int i = 1; i <result.size (); i ++) {
                        	int _t = result.get(i) -result.get (i-1); 
                            partList.add (_t);
                        } 
                }
                partList.add (list.size () - result.get (result.size () - 1));
                
                for (Integer i: partList) {
                        System.out.println (i);
                }
                return partList;
        }

}

