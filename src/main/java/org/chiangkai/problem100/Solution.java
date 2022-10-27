package org.chiangkai.problem100;

/**
 * @author ChiangKai
 * @date 2022/10/27
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
        return false;
    }


}
