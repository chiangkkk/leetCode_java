#### [面试题 01.02. 判定是否互为字符重排](https://leetcode.cn/problems/check-permutation-lcci/)

难度简单

给定两个字符串 `s1` 和 `s2`，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

**示例 1：**

```
输入: s1 = "abc", s2 = "bca"
输出: true 
```

**示例 2：**

```
输入: s1 = "abc", s2 = "bad"
输出: false
```

**说明：**

- `0 <= len(s1) <= 100`
- `0 <= len(s2) <= 100`

```java
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            // 记录异或和  a⊗a=0 如果s1和s2一样 异或和 为 0
            int xor = 0;
            // 记录hash
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                xor ^= s1.charAt(i);
                map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            }
            for (int i = 0; i < s2.length(); i++) {
                xor ^= s2.charAt(i);
                map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            }
            // 存在 s1 = aa s2 = bb 的情况，用hash记录解决
            if (xor == 0) { 
                if (map1.size() == map2.size()) {
                    for (Character character : map1.keySet()) {
                        if (map2.containsKey(character)) {
                            if (!map1.get(character).equals(map2.get(character))) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
```