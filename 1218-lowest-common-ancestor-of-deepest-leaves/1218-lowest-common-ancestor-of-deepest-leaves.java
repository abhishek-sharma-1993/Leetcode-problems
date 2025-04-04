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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode root){
        if(root == null) 
            return new Pair(root, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if(left.depth > right.depth)
            return new Pair(left.node, left.depth+1);

        if(right.depth > left.depth)
            return new Pair(right.node, right.depth+1);

        return new Pair(root, left.depth+1);
    }
}

class Pair{
    TreeNode node;
    int depth;
    Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}