package org.chiangkai.problem21;

/**
 * <p>
 * <h1> 合并有序序列</h1>
 * <img src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" />
 * </p>
 *
 * @author ChiangKai
 * @date 2022/10/27
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp1 = list1, temp2 = list2, temp = head;
        while (temp1 != null && temp2 != null) {
            int val1 = temp1.val;
            int val2 = temp2.val;
            if (val1 < val2) {
                ListNode listNode = new ListNode(val1);
                temp.next = listNode;
                temp = listNode;
                temp1 = temp1.next;
            } else {
                ListNode listNode = new ListNode(val2);
                temp.next = listNode;
                temp = listNode;
                temp2 = temp2.next;
            }
        }
        temp.next = temp1 != null ? temp1 : temp2;
        return head.next;
    }
}
