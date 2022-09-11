package org.chiangkai.problem857;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ChiangKai
 * @date 2022/9/11 15:50
 */
public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double res = Double.MAX_VALUE;
        double date[][] = new double[quality.length][2];
        double workers[][] = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            date[i][0] = (wage[i] + 0.0) / quality[i];
            date[i][1] = quality[i];
            workers[i] = new double[] {(double) wage[i] / quality[i], (double) quality[i]};
        }
        Arrays.sort(date, (x, y) -> Double.compare(x[0], y[0]));

        PriorityQueue<Double> query = new PriorityQueue<>((x, y) -> Double.compare(y, x));
        double sum = 0;
        for (double[] work : date) {
            if (query.size() == k)
                sum -= query.poll();
            query.offer(work[1]);
            sum += work[1];
            if (query.size() == k) {
                res = Math.min(sum * work[0], res);
            }
        }
        return res;
    }
}
