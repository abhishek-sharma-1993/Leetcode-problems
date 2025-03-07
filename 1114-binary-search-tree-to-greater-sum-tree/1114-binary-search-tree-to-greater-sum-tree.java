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

    public TreeNode bstToGst(TreeNode root) {
        int[] nodeSum = new int[1];
        bstToGstHelper(root, nodeSum);
        return root;
    }

    private void bstToGstHelper(TreeNode root, int[] nodeSum) {
        // If root is null, make no changes.
        if (root == null) {
            return;
        }

        bstToGstHelper(root.right, nodeSum);
        nodeSum[0] += root.val;
        // Update the value of root.
        root.val = nodeSum[0];
        bstToGstHelper(root.left, nodeSum);
    }
}