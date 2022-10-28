package org.chiangkai.problem83;


/**
 * <h1>给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * </h1>
 * <p>
 * eg1:
 * <p>
 * 输入：head = [1,1,2]
 * <br>
 * 输出：[1,2]
 * </p>
 * <br>
 * <image src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" />
 * </p>
 * <p>
 * eg2:
 * <br>
 * 输入：head = [1,1,2,3,3]
 * <br>
 * 输出：[1,2,3]
 * <br>
 * <image src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" />
 * </p>
 *
 * @author ChiangKai
 * @date 2022/10/27
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(), sourceTemp = head, resTemp = res;
        int last = Integer.MIN_VALUE;
        while (sourceTemp != null) {
            if (sourceTemp.val != last) {
                ListNode listNode = new ListNode(sourceTemp.val);
                resTemp.next = listNode;
                resTemp = listNode;
                last = listNode.val;
            }
            sourceTemp = sourceTemp.next;
        }
        return res.next;
    }
}
