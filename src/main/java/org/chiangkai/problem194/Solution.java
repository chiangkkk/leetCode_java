package org.chiangkai.problem194;

/**
 * @author ChiangKai
 * @date 2023/1/13
 */
public class Solution {
    public int rearrangeCharacters(String s, String target) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        boolean addFlag = true;
        while (addFlag){
            for (char c : target.toCharArray()) {
                if (count[c-'a'] != 0){
                    count[c-'a']--;
                }else {
                    addFlag = false;
                    break;
                }
            }
            if (addFlag)
                res++;
        }
        return res;
    }
}
