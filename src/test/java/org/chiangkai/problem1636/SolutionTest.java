package org.chiangkai.problem1636;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1636(){
        Solution solution = new Solution();
        int[] ints = solution.frequencySort(new int[]{
                1, 1, 2, 2, 2, 3});
        Arrays.stream(ints).forEach(System.out::print);
    }

}