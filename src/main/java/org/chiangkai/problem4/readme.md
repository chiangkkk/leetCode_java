#### [4. 寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/)

难度:**困难**

给定两个大小分别为 `m` 和 `n` 的正序（从小到大）数组 `nums1` 和 `nums2`。请你找出并返回这两个正序数组的 **中位数** 。

算法的时间复杂度应该为 `O(log (m+n))` 。

 

**示例 1：**

```
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
```

**示例 2：**

```
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
```

 

 

**提示：**

- `nums1.length == m`
- `nums2.length == n`
- `0 <= m <= 1000`
- `0 <= n <= 1000`
- `1 <= m + n <= 2000`
- `-106 <= nums1[i], nums2[i] <= 106`

## 解题

```java
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1 = nums1.length;
        int num2 = nums2.length;
        int countNum = num1 + num2;
        boolean isDouble = countNum % 2 != 1;
        int last = 0, result = 0, now1 = 0, now2 = 0;
        for (int i = 0; i <= countNum / 2; i++) {
            last = result;
            if (now1<num1 && now2 < num2) {
                if (nums1[now1] < nums2[now2]) {
                    result = nums1[now1];
                    now1++;
                } else {
                    result = nums2[now2];
                    now2++;
                }
            } else if (now1 == num1) {
                result = nums2[now2];
                now2++;
            } else {
                result = nums1[now1];
                now1++;
            }
        }
        if (isDouble) {
            // 遇到的 int/int = int 的坑
            return (result + last + 0.0) / 2;
        }
        return result;
    }
}
```