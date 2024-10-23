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
    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> levelSum = new HashMap<>();
        dfs(root, 0, levelSum);
        root.val = 0;
        dfs1(root, 1,levelSum);
        return root;
    }

    void dfs(TreeNode root, int level, Map<Integer, Integer> levelSum){
        if(root == null) return;

        int sum = levelSum.getOrDefault(level, 0) + root.val;
        levelSum.put(level, sum);
        dfs(root.left, level+1, levelSum);
        dfs(root.right, level+1, levelSum);
    }

    void dfs1(TreeNode root, int level, Map<Integer, Integer> levelSum){
        if(root == null) return;

        int sum = 0;
        if(root.left != null){
            sum += root.left.val;
        }
        if(root.right != null){
            sum += root.right.val;
        }

        int currlevelSum = levelSum.getOrDefault(level, 0);

        if(currlevelSum > 0){
            int tmp = currlevelSum-sum;
            if(root.left != null){
                root.left.val = tmp;
            }
            if(root.right != null){
                root.right.val = tmp;
            }
        }

        dfs1(root.left, level+1, levelSum);
        dfs1(root.right, level+1, levelSum);
    }
}