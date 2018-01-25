package com.interview.priority;

public class SJF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double WaitAverage(int[] request, int[] duration) {  
	    // TODO Auto-generated method stub  
	    if(request == null || duration == null || request.length == 0 || duration.length ==0)  
	        return 0;  
	      
	    int length = request.length;  
	    int count = 0;  
	      
	    int waitTime = 0;  
	    int CurrentTime = 0;  
	    int CurP = 0;  
	      
	    while(count < length)  
	    {  
	        if(CurP == 0)  
	        {  
	            CurrentTime = duration[0];  
	            duration[0] = 0;  
	            count++;  
	        }  
	        else  
	        {  
	            waitTime += CurrentTime - request[CurP];  
	            CurrentTime += duration[CurP];  
	            duration[CurP] = 0;  
	            count++;  
	        }  
	          
	        int min = Integer.MAX_VALUE;  
	          
	        int remain = 0;  
	        for(int i = 0; i < length ; i++)  
	        {  
	            if(duration[i] != 0)  
	            {  
	                remain++;  
	                if(request[i] < CurrentTime)  
	                {  
	                    if(min > duration[i])  
	                    {  
	                        min = duration[i];  
	                        CurP = i;  
	                    }  
	                }  
	            }  
	        }  
	          
	        if(min == Integer.MAX_VALUE)  
	            if(remain>0 && remain < length)  
	            {  
	                for(int i=0; i < length; i++)  
	                {  
	                    if(duration[i]!=0)  
	                    {  
	                        CurP = i;  
	                        CurrentTime = request[i];  
	                        break;  
	                    }  
	                }  
	            }  
	          
	    }  
	      
	    return (double)waitTime/(double)length;  
	}  

}
