package org.chiangkai.problem344;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTest {
    @Test
    public void test344(){
        Solution solution = new Solution();
        char[] chars = new char[]{'h','e','l','l','o'};
        solution.reverseString(chars);
        log.info("{}",chars);
    }

}