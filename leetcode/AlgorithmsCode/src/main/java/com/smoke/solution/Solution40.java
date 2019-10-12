/**
 * #40
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
package com.smoke.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Smoke
 *
 */
public class Solution40 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
		if(candidates.length == 0) return res;
		
		Arrays.sort(candidates);
		
		combinationSumRecursive(res, target, candidates, 0, null);
		
    	return res;
    }

    
    private void combinationSumRecursive(
    		List<List<Integer>> res, int target, int[] candidates, int start, List<Integer> combination)
    {
    	
    	for(int i = start; i < candidates.length; i++){
    		
    		List<Integer> newCombination = new ArrayList<Integer>();;
        	if(combination != null){
        		newCombination = new ArrayList<Integer>(combination);
        	}

			newCombination.add(candidates[i]);
			int newTarget = target - candidates[i];
			
			if(newTarget < 0)
				return;
			if(newTarget == 0){
	    		res.add(newCombination);
	    		return;
			}
            
			/*
			 * 与#39题不同的地方：1)传递下一个索引	2)去重
			 */
            if(i+1 < candidates.length) {
                combinationSumRecursive(res, newTarget, candidates, i + 1, newCombination);
                while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
                    i++;
                }
            }
    	}
    }
}
