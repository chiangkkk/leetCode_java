package org.chiangkai.problem1598;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void test1598(){
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
    }

}