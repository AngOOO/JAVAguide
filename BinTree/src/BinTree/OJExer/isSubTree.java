package BinTree.OJExer;

import java.util.LinkedList;
import java.util.Queue;

public class isSubTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
       if (isSameTree(s,t)){
           return true;
       }
       if (s!=null && t!=null){
           if (isSubtree(s.left,t)){
               return true;
           }else if (isSubtree(s.right,t)){
               return true;
           }
       }
       return false;
    }
    private boolean isSameTree(TreeNode p,TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p != null && q != null && p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
