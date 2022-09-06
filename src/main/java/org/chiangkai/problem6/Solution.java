package org.chiangkai.problem6;

import java.util.ArrayList;
import java.util.List;

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
        List<StringBuilder> sbs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbs.add(new StringBuilder());
        }
        int flag = -1;
        int line = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs.get(line).append(s.charAt(i));
            if (line == 0 || line + 1 == numRows) flag = -flag;
            line +=flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : sbs) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }
}
