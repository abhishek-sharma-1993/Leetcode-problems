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
    // 1     2    null   
    // prev curr  nxt
    // prev       curr 

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode nxt = curr.next;
            int data = curr.val;
            if(set.contains(data)){
                if(prev != null){
                    prev.next = nxt;
                    curr = nxt;
                    if(nxt != null ) nxt = nxt.next;
                    else break;

                }else{
                    head = nxt;
                    curr = nxt;
                    if(nxt != null ) nxt = nxt.next;
                    else break;
                }
            }else{
                prev = curr;
                curr = nxt;
                if(nxt != null ) nxt = nxt.next;
                else break;
            }
        }

        return head;
    }

    
}