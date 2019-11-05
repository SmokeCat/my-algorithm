package com.smoke.solution;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        
        if(nums == null || len == 0) return false;
        
        int lo = 0, hi = len - 1;
        
        while(lo <= hi){
        	int mid = lo + ((hi - lo) >> 1);
        	
        	if(nums[mid] == target) return true;
        	
        	if(nums[lo] == nums[mid]){
        		++lo;
        		continue;
        	}
        	
        	if(nums[0] < nums[mid]){
        		if(target >= nums[lo] && target < nums[mid]){
        			hi = mid - 1;
        		}else{
        			lo = mid + 1;
        		}
        	}else{
        		if(target > nums[mid] && target <= nums[hi]){
        			lo = mid + 1;
        		}else{
        			hi = mid - 1;
        		}
        	}
        }
        return false;
    }
}
