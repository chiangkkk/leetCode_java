package org.chiangkai.problem854;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author ChiangKai
 * @date 2022/9/21
 */
public class Solution {
    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        if (n > 1){
            Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
            Set<String> visit = new HashSet<>();
            queue.offer(new Pair<>(s1, 0));
            visit.add(s1);
            int step = 0;
            while (!queue.isEmpty()) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    Pair<String, Integer> pair = queue.poll();
                    String cur = pair.getKey();
                    int pos = pair.getValue();
                    if (cur.equals(s2)) {
                        return step;
                    }
                    while (pos < n && cur.charAt(pos) == s2.charAt(pos)) {
                        pos++;
                    }
                    for (int j = pos + 1; j < n; j++) {
                        if (s2.charAt(j) == cur.charAt(j)) {
                            continue;
                        }
                        if (s2.charAt(pos) == cur.charAt(j)) {
                            String next = swap(cur, pos, j);
                            if (!visit.contains(next)) {
                                visit.add(next);
                                queue.offer(new Pair<>(next, pos + 1));
                            }
                        }
                    }
                }
                step++;
            }
            return step;
        }
        return 1;
    }
    public String swap(String cur, int i, int j) {
        char[] arr = cur.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
}
