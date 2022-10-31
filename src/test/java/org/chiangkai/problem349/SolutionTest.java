package org.chiangkai.problem349;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTest {
    @Test
    public void test349() {
        Solution solution = new Solution();
        int[] res = solution.intersection(new int[]{1, 2, 3, 4, 5}, new int[]{3, 2, 33, 3, 2});
        log.info("res={}", res);
    }

}