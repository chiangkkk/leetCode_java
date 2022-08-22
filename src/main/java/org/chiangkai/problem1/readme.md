#### [1. 两数之和](https://leetcode.cn/problems/two-sum/)

难度 **简单**

给定一个整数数组 `nums` 和一个整数目标值 `target`，
请你在该数组中找出 **和为目标值** *`target`* 的那 **两个** 
整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

 

**示例 1：**

```
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

**示例 2：**

```
输入：nums = [3,2,4], target = 6
输出：[1,2]
```

**示例 3：**

```
输入：nums = [3,3], target = 6
输出：[0,1]
```
## 解决方案

1. 暴力解法
时间复杂读 O(N^2)
空间复杂度 O(1)
```java
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }
}
```

2. 哈希表 

空间复杂都O(N)
时间复杂度O(N)
- 双循环方案
```java
public class Solution {
    // 存在bug1 等值问题 eg: nums: [3,2,4] target:6 此答案输出 [0,0] 预期答案 [1,2]
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        // key nums中的每个值对应的补数，value 对应的下表
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // 解决 bug1 添加等值判断
                if(i == map.get(nums[i])){
                    continue;
                }
                return new int[]{i, map.get(nums[i])};
            }
        }
        return new int[0];
    }
}
```
- 单循环方案
```java
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}

```
- 双向收敛方案 
用时 0ms :satisfied:
```java
public class Solution {
    //  双向收敛  
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            if (map.containsKey(target - nums[j])) {
                return new int[]{map.get(target - nums[j]), j};
            }
            map.put(nums[i], i);
            map.put(nums[j], j);
        }
        return new int[0];
    }
}

```
