/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];

        for(int i=0; i<m; i++)
            Arrays.fill(ans[i], -1);

        ListNode node = head;
        int top=0,bottom=m-1;
        int left=0,right=n-1;

        while(node!=null){

            for(int i=left; i<=right && node!=null; i++){
                ans[top][i]=node.val;
                node = node.next;
            }
            top++;

            for(int i=top; i<=bottom && node!=null; i++){
                ans[i][right]=node.val;
                node = node.next;
            }
            right--;

            for(int i=right; i>=left && node!=null; i--){
                ans[bottom][i]=node.val;
                node = node.next;
            }
            bottom--;

            for(int i=bottom; i>=top && node!=null; i--){
                ans[i][left]=node.val;
                node = node.next;
            }
            left++;
        }
        
        return ans;
    }
}