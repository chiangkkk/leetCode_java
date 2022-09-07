package org.chiangkai.problem1592;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChiangKai
 * @date 2022/9/7 23:05
 */
public class Solution {
    public String reorderSpaces(String text) {
        List<StringBuilder> sbs = new ArrayList<>();
        int spaceCount = 0;
        boolean preIsLetter = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                preIsLetter = false;
                spaceCount++;
            } else {
                if (!preIsLetter) {
                    StringBuilder stringBuilder = new StringBuilder(text.charAt(i));
                    sbs.add(stringBuilder);
                }
                StringBuilder stringBuilder = sbs.get(sbs.size() - 1);
                stringBuilder.append(text.charAt(i));
                preIsLetter = true;
            }
        }
        int wordCount = sbs.size();
        int gapSpaceCount,remainSpace;
        if (wordCount > 1){
            gapSpaceCount = spaceCount / (wordCount - 1);
        }else {
            gapSpaceCount = 0;
        }
        remainSpace = spaceCount - gapSpaceCount * (wordCount - 1);
        StringBuilder result = new StringBuilder();
        StringBuilder gapString = new StringBuilder();
        for (int i = 0; i < gapSpaceCount; i++) {
            gapString.append(' ');
        }
        for (int i = 0; i < sbs.size(); i++) {
            result.append(sbs.get(i));
            if (i != sbs.size() - 1) {
                result.append(gapString);
            }
        }
        for (int i = 0; i < remainSpace; i++) {
            result.append(' ');
        }
        return result.toString();
    }
}
