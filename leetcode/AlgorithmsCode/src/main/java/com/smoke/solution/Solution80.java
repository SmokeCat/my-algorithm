package com.smoke.solution;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 3) return len;
        int i = 0;
        
        for(int p = 0, num; p < len;){
            num = nums[p];
            
            nums[i++] = nums[p++];
            if(p < len && nums[p] == num){
                nums[i++] = nums[p++];
                while(p < len && nums[p] == num){
                    ++p;
                }
            }
        }
        
        return i;
    }
}
