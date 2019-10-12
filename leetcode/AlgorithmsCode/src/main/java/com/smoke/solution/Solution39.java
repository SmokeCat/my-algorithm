/**
 * #39
 * https://leetcode-cn.com/problems/combination-sum/
 */
package com.smoke.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Smoke
 *
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
		if(candidates.length == 0) return res;
		
		Arrays.sort(candidates);
		
		combinationSumRecursive(res, target, candidates, 0, null);
		
    	return res;
    }
    
    /**
     * 
     * @param res 最终结果
     * @param target 目标和
     * @param candidates 给定的数组
     * @param start 从start开始寻找
     * @param combination 结果中的一个组合
     */
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
			
			combinationSumRecursive(res, newTarget, candidates, i, newCombination);
    	}
    }
    
	/*
	 *	有重复代码，优化后如上
	 */
//    private void combinationSumRecursive(
//    		List<List<Integer>> res, int target, int[] candidates, int start, List<Integer> combination)
//    {
//    	if(combination == null){
//    		for(int i = 0; i < candidates.length; i++){
//    			List<Integer> newCombination = new ArrayList<Integer>();
//    			newCombination.add(candidates[i]);
//    			combinationSumRecursive(res, target - candidates[i], candidates, i, newCombination);
//    		}
//    		return;
//    	}
//    	
//    	if(target==0 && combination != null){
//    		res.add(combination);
//    	}else if(target < 0){
//    	}else{
//        	for(int i = start; i < candidates.length; i++){
//        		if(target < candidates[i]){
//        			return ;
//        		}
//        		List<Integer> newCombination = new ArrayList<Integer>(combination);
//        		newCombination.add(candidates[i]);
//        		combinationSumRecursive(res, target - candidates[i], candidates, i, newCombination);
//        	}
//    	}
//    }
}
