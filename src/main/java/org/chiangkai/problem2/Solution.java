package org.chiangkai.problem2;

/**
 * * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode() {}
 * *     ListNode(int val) { this.val = val; }
 * *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * * }
 * <p>
 * eg :
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * @author ChiangKai
 * @date 2022/8/22 23:21
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(), temp = null;
        int addTemp = 0;
        boolean initFlag = true;
        //addTemp==1 解决进位为1 l1 和 l2 都为null的场景
        while (l1 != null || l2 != null || addTemp == 1) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            if (initFlag) {
                int sum = n1 + n2;
                if (n1 + n2 > 9) {
                    //单位加法最大 9+9 = 18 进位最大为1， 不可能大于20，减10 就可以取个位数
                    addTemp = 1;
                    head.val = n1 + n2 - 10;
                } else {
                    head.val = sum;
                }
                temp = head;
                initFlag = false;
            } else {
                ListNode newNode = new ListNode();
                if (n1 + n2 + addTemp > 9) {
                    newNode.val = n1 + n2 + addTemp - 10;
                    addTemp = 1;
                } else {
                    newNode.val = n1 + n2 + addTemp;
                    addTemp = 0;
                }
                temp.next = newNode;
                temp = newNode;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head;
    }

    public ListNode arrayToListNode(int[] arr) {
        ListNode head = null, temp = null;
        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = new ListNode();
                head.val = arr[i];
                temp = head;
            } else {
                ListNode newNode = new ListNode();
                newNode.val = arr[i];
                temp.next = newNode;
                temp = newNode;
            }
        }
        return head;
    }

    public void printListNode(ListNode listNode) {
        System.out.print("[");
        StringBuilder sb = new StringBuilder();
        while (null != listNode) {
            int val = listNode.val;
            System.out.print(val);
            sb.append(val);
            listNode = listNode.next;
            if (null != listNode) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
        System.out.println(sb.reverse().toString());

    }
}