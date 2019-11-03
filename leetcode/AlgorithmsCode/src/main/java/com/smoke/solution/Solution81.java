package com.smoke.solution;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        
        if(len < 1) return false;
        
        return rotatedSearch(nums, 0, len - 1, target);
    }
    
    private boolean binSearch(int[] nums, int start, int end, int target){
        if(end < start) return false;
        int mid = start + ((end - start) >> 1);
        if(nums[start] == nums[mid] && nums[mid] == nums[end])  return nums[start] == target ? true : false;
        
        if(nums[mid] == target){
            return true;
        }else if(target < mid){
            return binSearch(nums, start, mid-1, target);
        }else{
            return binSearch(nums, mid+1, end, target);
        }
    }
    
    private boolean rotatedSearch(int[] nums, int start, int end, int target){
        if(end < start) return false;
        int mid = start + (end - start) >> 1;
        if(nums[start] == nums[mid] && nums[mid] == nums[end])  return nums[start] == target ? true : false;
        
        if(nums[mid] == target){
            return true;
        } else if(nums[start] < nums[mid]){
            if(target >= nums[start] && target < nums[mid]){
                return binSearch(nums, start, mid-1, target);
            }else{
                return rotatedSearch(nums, mid+1, end, target);
            }
        } else{
            if(target > nums[mid] && target <= nums[end]){
                return binSearch(nums, mid+1, end, target);
            }else{
                return rotatedSearch(nums, start, mid-1, target);
            }
        }
    }
}
