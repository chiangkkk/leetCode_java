package org.chiangkai.problem58;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 *
 * @author ChiangKai
 * @date 2022/11/1
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int now = 0;
        boolean initFlag = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (!initFlag)
                    break;
            } else {
                now++;
                initFlag = false;
            }
        }
        return now;
    }
}
