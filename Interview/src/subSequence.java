import java.util.*;


public class subSequence {
	public static List<Integer> Check(List<String> targetList,List<String> availableList ) {
		
	       HashSet<String> target = new HashSet<String>();
			for(String word : targetList) {
			    target.add(word);
			}
			List<Integer> result = new ArrayList<Integer>(); 
			
			HashMap<String, Integer> running = new HashMap<String, Integer>();
			int start = 0;
			int minStart = 0;
			int minEnd = Integer.MAX_VALUE;
			
			for (int i =0;i<availableList.size();i++) {
			    String word = availableList.get(i);
			    if (target.contains(availableList.get(i))) {
			        if (running.containsKey(word)) {
			           running.put(availableList.get(i), running.get(word) + 1); 
			        } else {
			           running.put(availableList.get(i), 1);
			        }
			    }
			    
			    if (running.size() == target.size()) {
			        // move start as much as possible
			        while(running.size() == target.size()) {
			            String wordStart = availableList.get(start);
			            if (running.containsKey(wordStart)) {
			                int c = running.get(wordStart);
			                if (c>1) {
			                    running.put(wordStart, running.get(wordStart) - 1); 
			                } else {
			                    running.remove(wordStart);
			                }
			            }
			            
			            start++;
			        }
			        
			        int newStart = start - 1;
			        if (i-newStart < minEnd-minStart) {
			            minStart=newStart;
			            minEnd=i;
			        }
			    }
			}
			result.add(minStart);
			result.add(minEnd);
			
			return result;
	     }
	        
	    

		public static void main(String[] args) {
			
			List<String> targetList = new ArrayList<String>();
			targetList.add("made");
			targetList.add("in");
			targetList.add("spain");
			
			List<String> availableList = new ArrayList<String>();
			availableList.add("made");
			availableList.add("weather");
			availableList.add("forecast");
			availableList.add("says");
			availableList.add("that");
			availableList.add("made");
			availableList.add("rain");
			availableList.add("in");
			availableList.add("spain");
			availableList.add("stays");
			List<Integer> result = Check(targetList,availableList);
			
			for(int s: result)
				System.out.println(s);
			
		}
}
