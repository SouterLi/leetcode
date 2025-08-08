package leetcode.hot100;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            res.add(list.getLast().val);
            for(int i =0;i<list.size(); i++) {
                if(list.get(i).left != null) {
                    temp.add(list.get(i).left);
                }
                if(list.get(i).right != null) {
                    temp.add(list.get(i).right);
                }
            }
            list = temp;
        }

        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;

        Solution199 solution199 = new Solution199();
        List<Integer> res = solution199.rightSideView(root);
        System.out.println(res); // Output: [1, 3, 4]
    }
}
