package org.chiangkai.prolbem704;

/**
 * @author ChiangKai
 * @date 2023/2/28
 */
public class Solution {
    public int search(int[] nums, int target) {
//        return binarySearch(0, nums.length - 1, nums, target);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    int binarySearch(int left, int right, int[] nums, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return binarySearch(left, mid - 1, nums, target);
        else return binarySearch(mid + 1, right, nums, target);
    }
}
