package com.smoke.solution;

import java.util.Arrays;

public class Solution75 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len <= 1) return;
        
        int p = 0, pLeft = 0, pRight = len - 1;
        while(p <= pRight ){
            if(nums[p] == 0){
                int tmp = nums[pLeft];
                nums[pLeft] = nums[p];
                nums[p] = tmp;
                ++pLeft;
                ++p;
            }else if(nums[p] == 2){
                int tmp = nums[pRight];
                nums[pRight] = nums[p];
                nums[p] = tmp;
                --pRight;
            }else{
                ++p;
            }
        }
    }
    
    /**
     *	测试Solution 75
     *
     * @param args
     */
    public static void main(String[] args) {
		System.out.println("Test Solution 75");
		
		Solution75 s75 = new Solution75();
		
		int[] nums = new int[]{0,0,2,1,0,1,2,2,1,2,2};
		
		s75.sortColors(nums);
		
		System.out.println(Arrays.toString(nums));
	}
}
