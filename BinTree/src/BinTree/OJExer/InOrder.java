package BinTree.OJExer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null){
                return Collections.emptyList();
            }
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
            return list;
        }

    }
}
