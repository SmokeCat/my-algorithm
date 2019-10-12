# 40. 组合总和 II
https://leetcode-cn.com/problems/combination-sum-ii/

## 题目描述

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 

示例 1:
```
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```

示例 2:
```
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
```

## 题解

### 解决思路：

同#39题，修改两处：

    1.递归传递的开始索引为当前索引+1，
    2.在递归函数返回后添加一个while循环去重。
``` 
if(i+1 < candidates.length) {
    combinationSumRecursive(res, newTarget, candidates, i + 1, newCombination);
    while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
        i++;
    }
}
```

### 代码

java代码:
~~~ java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            
            if(i+1 < candidates.length) {
                combinationSumRecursive(res, newTarget, candidates, i + 1, newCombination);
                while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
                    i++;
                }
            }
    	}
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n^2)$

空间复杂度：$O(1)$

## 其他方法
