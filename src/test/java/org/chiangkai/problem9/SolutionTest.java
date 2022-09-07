package org.chiangkai.problem9;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void test10(){
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(121);
        System.out.println(palindrome);
    }

}