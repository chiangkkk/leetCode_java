package org.chiangkai.problem6;

/**
 * @author ChiangKai
 * @date 2022/9/5 22:14
 */
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
            System.out.println(addNum);
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
