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
    public List<Integer> largestValues(TreeNode root) {
        TreeNode curr = root;
        TreeNode last = root;
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        int rowMax = Integer.MIN_VALUE;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            rowMax = Math.max(rowMax, node.val);

            if(node.left != null) queue.addLast(node.left);
            if(node.right != null) queue.addLast(node.right);

            if(node == last){
                ans.add(rowMax);
                rowMax = Integer.MIN_VALUE;
                last = !queue.isEmpty() ? queue.getLast() : null;
            }
        }
        return ans;
    }
}