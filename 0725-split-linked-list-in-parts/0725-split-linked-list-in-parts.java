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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode node = head;
        while(node != null){
            n++;
            node = node.next;
        }

        int extra = n%k;
        int parts = n/k;

        ListNode curr = head;
        ListNode prev = curr;
        ListNode[] ans = new ListNode[k];
        for(int i=0; i<k; i++){
            ListNode newPart = curr;
            int size = parts;
            if(extra>0){
                extra--;
                size++;
            }

            int j=0;
            while(j<size){
                prev = curr;
                curr = curr.next;
                j++;
            }
            
            if(prev != null){
                prev.next = null;
            }

            ans[i]=newPart;
        }
        return ans;
    }
}