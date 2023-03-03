package org.chiangkai.prolbem1487;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChiangKai
 * @date 2023/3/3
 */
public class Solution {

    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!cache.containsKey(name)) {
                res[i] = name;
                cache.put(name, 1);
            } else {
                Integer count = cache.get(name);
                while (cache.containsKey(name + "(" + count + ")")) {
                    count++;
                }
                res[i] = name + "(" + count + ")";
                cache.put(name, count + 1);
                cache.put(res[i], 1);
            }
        }
        return res;
    }
}
