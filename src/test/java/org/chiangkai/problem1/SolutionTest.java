package org.chiangkai.problem1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTest {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] ints = {3, 2, 4};
        int target = 6;
        int[]  result = solution.twoSum(ints, target);
        log.info("{}", result);
    }
}