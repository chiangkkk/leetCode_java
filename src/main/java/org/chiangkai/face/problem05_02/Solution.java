package org.chiangkai.face.problem05_02;

/**
 * @author ChiangKai
 * @date 2023/3/2
 */
public class Solution {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0) {
            num *= 2;
            int temp = (int) num;
            sb.append(temp);
            num -= temp;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }
}
