/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean ans;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        this.ans = true;
        helper(p,q);
        return ans;
    }

    private void helper(TreeNode p, TreeNode q){
        if(p == null && q == null) return;
        if(p != null && q == null) {
            ans = false;
            return;
        }
        if(p == null && q != null) {
            ans = false;
            return;
        }
        if(p.val != q.val) {
            ans = false;
            return;
        }

        helper(p.left, q.left);
        helper(p.right, q.right);
    }
}