# 41. 缺失的第一个正数
https://leetcode-cn.com/problems/two-sum/

## 题目描述

定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:
```
输入: [1,2,0]
输出: 3
```

示例 2:
```
输入: [3,4,-1,1]
输出: 2
```

示例 3:
```
输入: [7,8,9,11,12]
输出: 1
```

说明:

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。


## 题解

### 解决思路：

第一个缺失的整数应该在区间[1, nums.length+1] 中。所以创建一个长度为length的数组，将所有在区间[1,nums.length]中的数放入所在索引位置，最后遍历，第一个空元素的索引为第一个缺失的整数，遍历完后则返回nums.length + 1。

### 代码

java代码:
~~~ java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        if(len == 0) return 1;
        
        boolean[] bucket = new boolean[len+1];
        
        // 将区间[1, nums.length]中的数放入对应索引中
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                if(nums[i] < len+1){
                    bucket[nums[i]] = true;
                }
            }
        }
        
        // 第一个为false的数则为第一个缺失的正数
        for(int i = 1; i < len+1; i++){
            if(!bucket[i])  return i;
        }

        // bucket中全为true，则nums.length+1为第一个缺失的正数
        return len + 1;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(n)$

## 其他方法1

### 解决思路：

因为要求空间复杂度为$O(1)$，因此上述算法不满足条件。

可以将自身作为bucket。

首先预处理数组，将所有不在区间[1, length]的数都置为length+1。

然后遍历数组，将nums[nums[i]]置为-1.

* 若nums[nums[i]]在区间[1, length]中，先保存nums[nums[i]]的值，然后将nums[nums[i]]置为-1，接着将保存的值赋给i，循环，知道nums[nums[i]]不在区间中。

最后遍历数组，第一个大于0的索引为第一个缺失的正数。

代码中使用一个boolean类型的变量表示length，使得值和索引可以一一对应。

### 代码

java代码:
~~~ java
class Solution {
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
~~~

### 复杂度分析：

时间复杂度：$O(n)$

空间复杂度：$O(1)$

