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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        Queue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());

        deque.addLast(root);
        TreeNode last = root;
        long levelSum = 0;
        while(!deque.isEmpty()){
            TreeNode node = deque.removeFirst();
            levelSum += node.val*1l;

            if(node.left != null) deque.addLast(node.left);
            if(node.right != null) deque.addLast(node.right);

            if(node == last){
                heap.add(levelSum);
                levelSum = 0;
                last = !deque.isEmpty() ? deque.getLast() : null;
            }
        }
        long ans = 0;
        while(k>0){
            if(heap.isEmpty()) return -1;
            ans = heap.remove();
            k--;
        }
        return ans;
    }
}