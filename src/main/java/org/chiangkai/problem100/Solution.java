package org.chiangkai.problem100;

/**
 * @author ChiangKai
 * @date 2022/10/27
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return find(p, q);
    }

    public boolean find(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        } else if (p != null && q != null) {
            if (p.val == q.val) {
                if (find(p.left, q.left)) {
                    return find(p.right, q.right);
                }
            }
        }
        return false;
    }

}
