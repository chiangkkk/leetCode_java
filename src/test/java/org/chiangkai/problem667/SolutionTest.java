package org.chiangkai.problem667;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTest {


    @Test
    public void test667(){
        Solution solution = new Solution();
        int[] result = solution.constructArray(20, 7);
        log.info("result={}",result);
    }

}