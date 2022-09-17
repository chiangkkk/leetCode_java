package org.chiangkai.problem1624;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxLengthBetweenEqualCharacters() {
        Solution solution = new Solution();
        int res = solution.maxLengthBetweenEqualCharacters("pfwftcwdbiodyoojbebtwoyqemmsgmsryugkkcwykhtaczj");
        System.out.println(res);
    }
}