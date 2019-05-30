package BinTree.OJExer;


public class SoutPreorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public String tree2str(TreeNode t) {
            StringBuilder res = new StringBuilder();
            perOrder(t,res);
            return res.toString();
        }
        private void perOrder(TreeNode t,StringBuilder res){
            if (t == null){
                return;
            }
            res.append(t.val);
            if (t.left != null){
                res.append("(");
                perOrder(t.left,res);
                res.append(")");
            }else {
                if (t.right != null){
                    res.append("()");
                }
            }
            if (t.right != null){
                res.append("(");
                perOrder(t.right,res);
                res.append(")");
            }else {
                res.append("()");
            }
        }
    }
}
