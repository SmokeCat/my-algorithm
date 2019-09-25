# 15. 三数之和
https://leetcode-cn.com/problems/3sum/

## 题目描述

给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

```
例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

## 题解

### 解决思路：

之前写过两数之和，三数之和可以先确定一个数，然后在剩下的数里寻找两数之和。

但是因为不能重复，并且要寻找所有满足条件的集合，所以只是这样的思路不优化就是$O(n^3)$的时间复杂度。

优化思路：先将给定的数组排序，这样从头开始取一个数，然后在之后的数字里寻找符合条件的两数，遍历一遍后将找到所有组合。

因为是排序过的数组，所以在寻找剩余两个数时相比用哈希的算法有更有效率的方法，就是使用双指针，一个指针l指向第一个数后面，另一个指针r指向数组最后，这样判断三数和，若大于0，则只需l++,若小于0，则r--，知道l和r指针相遇，说明第一个数确定的所有组合都遍历了。

### 代码

java代码:
~~~ java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3) return res;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; ){
            // 选择了一个数的情况下，寻找符合条件两数之和。
            int l = i + 1, r = nums.length - 1;
            while(l < r && r < nums.length){
                // 寻找符合条件的两数
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r])));
                }
                // 去重
                // 注意特殊情况[0,0,0,0]
                if(sum <= 0){
                    // 三数和<0，将l右移
                    while(l + 1 < r && nums[l] == nums[l+1]){l++;}
                    l++;
                }else{
                    // 三数和>0，将r左移
                    while(r - 1 > l && nums[r] == nums[r-1]){r--;}  
                    r--;
                }                
            }
            
            // 更改i，注意避免重复组合
            while(i + 1 < nums.length - 2 && nums[i] == nums[i+1]){i++;}
            i++;
        }
        return res;
    }
}
~~~

### 复杂度分析：

时间复杂度：$O(n^2)$

空间复杂度：$O(1)$

