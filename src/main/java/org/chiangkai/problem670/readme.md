#### [670. 最大交换](https://leetcode.cn/problems/maximum-swap/)

难度:**中等**

给定一个非负整数，你**至多**可以交换一次数字中的任意两位。返回你能得到的最大值。

**示例 1 :**

```
输入: 2736
输出: 7236
解释: 交换数字2和数字7。
```

**示例 2 :**

```
输入: 9973
输出: 9973
解释: 不需要交换。
```

**注意:**

1. 给定数字的范围是 [0, 108]

## 题解
```java
// hash存储便利
class Solution {
    public int maximumSwap(int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] chars = (num + "").toCharArray();
        int posion = chars.length - 1;
        while (num != 0) {
            int remained = num % 10;
            if (!map.containsKey(remained)) {
                map.put(remained, posion);
            }
            posion--;
            num /= 10;
        }
        flag:
        for (int i = 0; i < chars.length - 1; i++) {
            int nowNum = Character.getNumericValue(chars[i]);
            for (int j = 9; j > nowNum; j--) {
                if (map.containsKey(j) && map.get(j) > i) {
                    swap(chars, i, map.get(j));
                    break flag;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
```

```java

//直接遍历
class Solution {

    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxNum = num;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(charArray, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
                swap(charArray, i, j);
            }
        }
        return maxNum;
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }


}
```

```java
// 贪心
class Solution {

    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int len = charArray.length;
        int idx1 = -1, idx2 = -1, maxId = len - 1;
        for (int i = maxId - 1; i >= 0; i--) {
            if (charArray[i] > charArray[maxId]) {
                maxId = i;
            } else if (charArray[i] < charArray[maxId]) {
                idx1 = maxId;
                idx2 = i;
            }
        }
        if (idx1 >= 0) {
            swap(charArray, idx1, idx2);
            return Integer.parseInt(new String(charArray));
        }

        return num;
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }


}
```