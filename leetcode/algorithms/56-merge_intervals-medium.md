# 56. 合并区间
https://leetcode-cn.com/problems/merge-intervals/

## 题目描述

给出一个区间的集合，请合并所有重叠的区间。

示例 1:
```
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
```

示例 2:
```
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
```

## 题解

### 解决思路：

根据区间的开始索引排序区间集合，然后遍历判断重叠区间。

重点在于如何排序。

### 代码

java代码:
~~~ java
class Solution {
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
}
~~~

### 复杂度分析：

时间复杂度：$O(n\log n)$

空间复杂度：$O(1)$
