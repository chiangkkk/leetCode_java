package org.chiangkai.problem670;

/**
 * @author ChiangKai
 * @date 2022/9/13 8:40
 */
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