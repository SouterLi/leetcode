package leetcode.hot100;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        build(preorder, inorder,0,preorder.length-1,0,inorder.length-1);
        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder,int pre_left, int pre_right, int in_left,int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        int pre_root = pre_left;
        int in_root = indexMap.get(preorder[pre_root]);

        TreeNode root = new TreeNode(preorder[pre_root]);

        int left_size = in_root - in_left;

        root.left = build(preorder, inorder, pre_left+1, pre_left+left_size, in_left, in_root-1);
        root.right = build(preorder, inorder,pre_left+left_size+1,pre_right, in_root+1, in_right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution105 solution105 = new Solution105();
        TreeNode root = solution105.buildTree(preorder, inorder);
        System.out.println(root.val); // Output: 3
        System.out.println(root.left.val); // Output: 9
        System.out.println(root.right.val); // Output: 20
    }
}
