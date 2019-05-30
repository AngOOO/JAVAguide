package BinTree.OJExer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    List<Integer> list = new ArrayList<>();
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null){
                return Collections.emptyList();
            }
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return list;
        }

    }
}
