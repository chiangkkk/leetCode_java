#### [647. 回文子串](https://leetcode.cn/problems/palindromic-substrings/)

难度:**中等**

给你一个字符串 `s` ，请你统计并返回这个字符串中 **回文子串** 的数目。

**回文字符串** 是正着读和倒过来读一样的字符串。

**子字符串** 是字符串中的由连续字符组成的一个序列。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

 

**示例 1：**

```
输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
```

**示例 2：**

```
输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
```

 

**提示：**

- `1 <= s.length <= 1000`
- `s` 由小写英文字母组成

## 解题

- 动态规划

```java

class Solution {
    public int countSubstrings(String s) {
        return 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        count++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

```

- 双指针
```java

class Solution {
    int num = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 0; i < s.length(); i++) {
            find(s, i, i);
            find(s, i, i + 1);
        }
        return num;
    }

    public void find(String s, int start, int end) {
        while (start > 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }
}
```