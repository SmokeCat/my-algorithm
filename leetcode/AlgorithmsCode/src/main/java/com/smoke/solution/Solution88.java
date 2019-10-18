/**
 * 
 */
package com.smoke.solution;

/**
 * @author Smoke
 *
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m - 1, j = n - 1, ptr = nums1.length - 1; ptr >= 0;){
            if(j < 0 || i >= 0 && nums1[i] >= nums2[j]){
                nums1[ptr--] = nums1[i--];
            }else{
                nums1[ptr--] = nums2[j--];
            }
        }
    }
}
