package com.sumit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();
        
        //if there is only one interval
        if(intervals.length<=1){
            return intervals;
        }
        
        /*
         * lets say if input is like this:
         * int [][] arr1 = {{15,18},{2,6},{8,10},{1,3}} inspite of {{1,3},{2,6},{8,10},{15,18}},
         * then it would not make sense.
         * so sort it based on start of each interval.
         */
        Arrays.sort(intervals, (array1, array2) -> Integer.compare(array1[0],array2[0]));
        
        
        int[] current_interval = intervals[0];
        list.add(current_interval);
      
        
      for(int i =0; i<intervals.length;i++)
      {
    	 int[]interval = intervals[i];
         int current_begin = current_interval[0];
         int current_end = current_interval[1];
         int next_begin = interval[0];
         int next_end = interval[1];
         
         //if current end of each interval is greater or equal to begin index of next interval
         if(current_end>=next_begin)
         {
        	 // updating the current end with max value.
             current_interval[1] = Math.max(current_end, next_end);    
         } 
         else 
         {  
        	 //updating current interval
             current_interval = interval;
             
             //adding to list
             list.add(current_interval);
         }
     }
        
        return list.toArray(new int[list.size()][]);
            
    }

	public static void main(String[] args) {
		int [][] arr1 = {{1,3},{2,6},{8,10},{15,18}};
		char[] c = {'0','s','u'};
		
		System.out.println(String.valueOf(c));
		String.valueOf(c).trim();
		System.out.println(Solution.merge(arr1));
	}
}
