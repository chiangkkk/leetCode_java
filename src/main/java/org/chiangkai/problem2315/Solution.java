package org.chiangkai.problem2315;

/**
 * @author ChiangKai
 * @date 2023/1/29
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAsterisks("l|*e*et|c**o|*de|"));
    }

    public int countAsterisks(String s) {
        String[] sArr = s.split("\\|");
        int result = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (i % 2 == 0) {
                char[] chars = sArr[i].toCharArray();
                for (char aChar : chars) {
                    if ('*' == aChar) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
