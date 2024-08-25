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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        if(root == null) return ans;

        TreeNode last = root;
        queue.addLast(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            tmp.add(node.val);

            if(node.left != null) queue.addLast(node.left);
            if(node.right != null) queue.addLast(node.right);

            if(node == last){
                ans.add(new ArrayList<>(tmp));
                tmp = new ArrayList<>();
                last = queue.isEmpty() ? null : queue.peekLast();
            }
        }

        return ans;
    }
}
