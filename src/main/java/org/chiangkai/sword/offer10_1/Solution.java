package org.chiangkai.sword.offer10_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChiangKai
 * @date 2022/10/28
 */
public class Solution {

    static Map<Integer, Integer> map = new HashMap<>();
    static int mod = (int) (1e9 + 7);

    static {

        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        for (int i = 3; i <= 100; i++) {
            int sum = 0;
            for (int j = i - 2; j < i; j++) {
                sum += map.get(j);
            }
            map.put(i, sum % mod);
        }
    }


    public int fib(int n) {

        System.out.println(mod);
        return 1;
    }
}
