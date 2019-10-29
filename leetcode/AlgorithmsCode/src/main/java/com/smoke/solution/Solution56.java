package com.smoke.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length < 1) return res.toArray(new int[0][]);

        // 按照区间start排序
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 0; i < intervals.length; i++){
        	if(intervals[i][0] > end){
        		res.add(new int[]{start, end});
        		start = intervals[i][0];
        		end = intervals[i][1];
        	}else{
            	end = Math.max(intervals[i][1], end);
        	}
        }
        res.add(new int[]{start, end});
        
        return res.toArray(new int[0][]);
    }
    
    /**
     * 测试Solution 56
     * 
     * @param args
     */
    public static void main(String[] args) {
		System.out.println("Test Solution 56:");
		
		Solution56 s56 = new Solution56();
		
		int[][] intervals = new int[][]{{1,4},{2,3}};
		
		int[][] res = s56.merge(intervals);
		
		for(int[] interval : res){
			System.out.println(Arrays.toString(interval));
		}
	}
}
