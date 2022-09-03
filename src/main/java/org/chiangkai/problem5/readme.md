#### [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/)

难度：**中等**

给你一个字符串 `s`，找到 `s` 中最长的回文子串。

 

**示例 1：**

```
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
```

**示例 2：**

```
输入：s = "cbbd"
输出："bb"
```

 

**提示：**

- `1 <= s.length <= 1000`
- `s` 仅由数字和英文字母组成

## 解题

#### 中心扩散法则
- 优化了相同字符串的处理
- 在全是相同字符下时间复杂度O(n) 最坏依然是O(n<sup>2</sup>)
```java
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] str = s.toCharArray();
        // record[0] 起始位置 record[1] 结束位置
        int[] record = new int[2];
        for (int i = 0; i < str.length; i++) {
            i = findLongestParlindrome(str, record, i);
        }
        return s.substring(record[0], record[1] + 1);
    }

    private int findLongestParlindrome(char[] str, int[] record, int low) {
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        int ans = high;
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        if (record[1] - record[0] < high - low) {
            record[0] = low;
            record[1] = high;
        }
        return ans;
    }


}


```

#### 动态规划

```java

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] str = s.toCharArray();
        int maxLen = 0, start = 0, end = 0;
        boolean dp[][] = new boolean[str.length][str.length];
        for (int i = str.length - 1; i >= 0; i--) {
            for (int j = i; j < str.length; j++) {
                if (str[i] == str[j]) {
                    if (j - i == 0 || j - i == 1) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    end = j;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }

}
```