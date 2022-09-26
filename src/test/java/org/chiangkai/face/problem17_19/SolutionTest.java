package org.chiangkai.face.problem17_19;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTest {
    @Test
    public void test17_19(){
        Solution solution = new Solution();
        log.info("res={}",solution.missingTwo(new int[]{3}));
    }

}