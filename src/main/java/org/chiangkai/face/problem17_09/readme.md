#### [面试题 17.09. 第 k 个数](https://leetcode.cn/problems/get-kth-magic-number-lcci/)

难度中等116收藏分享切换为英文接收动态反馈

有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。

**示例 1:**

```
输入: k = 5

输出: 9
```

## 题解
1. 最小堆
   

```java
public class Solution {
    public static int[] factorys = new int[]{3, 5, 7};

    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        queue.offer(1L);
        set.add(1L);
        
        int res = 0;
        for (int i = 0; i < k; i++) {
            Long poll = queue.poll();
            res = poll.intValue();
            for (int factory : factorys) {
                long temp = poll * factory;
                if (set.add(temp)){
                    queue.offer(temp);
                }
            }
        }
        return res;
    }
}
```