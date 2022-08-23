package org.chiangkai.problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testSolution2() {
        int[] arr1 = {9, 9, 9, 9, 9, 9, 9};
        int[] arr2 = {9, 9, 9, 9};
        Solution s2 = new Solution();
        ListNode l1 = s2.arrayToListNode(arr1);
        ListNode l2 = s2.arrayToListNode(arr2);
        ListNode result = s2.addTwoNumbers(l1, l2);
        s2.printListNode(result);

    }

}