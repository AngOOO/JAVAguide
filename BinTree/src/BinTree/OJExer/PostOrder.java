package BinTree.OJExer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostOrder {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null){
                return Collections.emptyList();
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
            return list;
        }
    }
}
