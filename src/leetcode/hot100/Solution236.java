package leetcode.hot100;

import leetcode.common.TreeNode;

public class Solution236 {
    private TreeNode result = null;

    private boolean hasNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        boolean left = hasNode(root.left, p, q);
        boolean right = hasNode(root.right, p, q);
        if(left && right || (root == p || root == q) && (left || right)) {
            result = root;
        }
        return left || right || root == p || root == q;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hasNode(root, p, q);
        return result;
    }
}
