package org.chiangkai.Problem66;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTest {


    @Test
    public void test66(){
        Solution solution = new Solution();
        int[] input = new int[]{9};
        int[] ints = solution.plusOne(input);
        log.info("{}",ints);
    }

}