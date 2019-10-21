/**
 * 
 */
package com.smoke.solution;

/**
 * @author Smoke
 *
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if(len == 0) return 1;
        
        boolean haveN = false;
        
        // 预处理数组
        for(int i = 0; i < len; i++){
            if(nums[i] < 1){
                nums[i] = len + 1;
            }else if(nums[i] == len){
                haveN = true;
            }
        }
        
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                 if(nums[i] < len){
                    //  循环赋值直到nums[i]不在区间[1, len-1]中
                    for(int j = nums[i]; j > 0 && j <= len;){
                        int temp = nums[j];
                        nums[j] = -1;
                        j = temp;
                        if(j == len){
                        	haveN = true;
                        	break;
                        }
                    }
                }else if(nums[i] == len){
                    haveN = true;
                }
            }
        }
        
        // 查找数组中第一个缺失的正数，第一个大于0的元素的索引就是第一个缺失的正数
        for(int i = 1; i < len; i++){
            if(nums[i] > 0) return i;
        }
        
        if(!haveN) return len;
        return len + 1;
    }

}
