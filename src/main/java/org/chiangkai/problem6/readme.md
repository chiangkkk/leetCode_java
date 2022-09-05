#### [6. Z 字形变换](https://leetcode.cn/problems/zigzag-conversion/)

难度：**中等**

将一个给定字符串 `s` 根据给定的行数 `numRows` ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 `"PAYPALISHIRING"` 行数为 `3` 时，排列如下：

```
P   A   H   N
A P L S I I G
Y   I   R
```

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：`"PAHNAPLSIIGYIR"`。

请你实现这个将字符串进行指定行数变换的函数：

```
string convert(string s, int numRows);
```

 

**示例 1：**

```
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
```

**示例 2：**

```
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
```

**示例 3：**

```
输入：s = "A", numRows = 1
输出："A"
```

 

**提示：**

- `1 <= s.length <= 1000`
- `s` 由英文字母（小写和大写）、`','` 和 `'.'` 组成
- `1 <= numRows <= 1000`

## 解题

找规律求解
```java
public class Solution {
    public String convert(String s, int numRows) {
        //可以直接返回的情况
        if (numRows == 1 || s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        //中间没数字的情况
        if (numRows == 2) {
            for (int i = 0; i < s.length(); i = i + 2) {
                sb.append(s.charAt(i));
            }
            for (int i = 1; i < s.length(); i = i + 2) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
        for (int i = 0; i < numRows; i++) {
            int addNum = 0;
            int totalGap = numRows * 2 - 2;
            // 第一行和最后一行差值都是 2n-2
            if (i == 0 || i + 1 == numRows) {
                addNum = totalGap;
            } else {
                addNum = i * 2;
            }
            for (int j = i; j < s.length(); j = j + addNum) {
                sb.append(s.charAt(j));
                if (addNum != totalGap) {
                    addNum = totalGap - addNum;
                }
            }
        }
        return sb.toString();
    }
}

```