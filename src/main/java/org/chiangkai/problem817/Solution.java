package org.chiangkai.problem817;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ChiangKai
 * @date 2022/10/12
 */
public class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        while (null != head) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val))
                    head = head.next;
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }
}
