package org.chiangkai.problem915;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void test915() {
        Solution solution = new Solution();
        int[] ints = {5, 0, 3, 8, 6};
        int res = solution.partitionDisjoint(ints);
        System.out.println(res);
    }

}