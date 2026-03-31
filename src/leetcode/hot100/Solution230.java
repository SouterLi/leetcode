package leetcode.hot100;

import leetcode.common.TreeNode;

public class Solution230 {
    int size = 1;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        dfs(root.left, k);
        if(size == k) {
            res = root.val;
            size++;
        } else {
            size ++;
        }
        dfs(root.right,k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.right = node3;

        Solution230 solution230 = new Solution230();
        int res = solution230.kthSmallest(root, 1);
        System.out.println(res);
    }
}
