package org.chiangkai.problem4;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4});
        System.out.println(medianSortedArrays);
    }

}