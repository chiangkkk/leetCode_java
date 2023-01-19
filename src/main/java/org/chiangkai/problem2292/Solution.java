package org.chiangkai.problem2292;

/**
 * @author ChiangKai
 * @date 2023/1/19
 */
public class Solution {

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean lower = false, upper = false, num = false, specLetter = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (i != 0 && c == password.charAt(i - 1))
                return false;
            if (c >= 'a' && c <= 'z')
                lower = true;
            else if (c >= 'A' && c <= 'Z')
                upper = true;
            else if (c >= '0' && c <= '9')
                num = true;
            else if ("!@#$%^&*()-+".indexOf(c) != -1)
                specLetter = true;
        }
        return lower && upper && num && specLetter;
    }
}
